package com.blob.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.models.BlobItem;
import com.blob.exceptions.BlobException;

@Service
public class AsyncBlobService {
	@Autowired
	BlobContainerAsyncClient blobContainerAsyncClient;

	public List<BlobItem> listAllBlobs() {
		return blobContainerAsyncClient.listBlobs().doOnError(throwable -> {
			throw new BlobException("Failed", "Error Occurred while receiving list of Blobs");
		}).collectList().block();
	}

	public void addBlob(String filePath, String fileName) {
		blobContainerAsyncClient.getBlobAsyncClient(fileName).uploadFromFile(filePath + fileName)
				.subscribe(file -> System.out.println("Uploading File " + fileName + " as a Blob"), throwable -> {
					throw new BlobException("Failed", "No file found as " + fileName + " at " + filePath);
				}, () -> System.out.println("Blob " + fileName + " uploaded Successfully"));

	}

	public void downloadBlob(String blobName, String downloadToFilePath) {
		blobContainerAsyncClient.getBlobAsyncClient(blobName).downloadToFile(downloadToFilePath + blobName).subscribe(
				file -> System.out.println("Donloading Blob " + blobName + " at " + downloadToFilePath), throwable -> {
					throw new BlobException("Failed", "No Such Blob available as " + blobName);
				}, () -> System.out.println("Blob " + blobName + " downloaded Successfully"));
	}

	public void deleteBlob(String blobName) {
		blobContainerAsyncClient.getBlobAsyncClient(blobName).delete()
				.subscribe(file -> System.out.println("Deleting Blob " + blobName), throwable -> {
					throw new BlobException("Failed", "No Such Blob available as " + blobName);
				}, () -> System.out.println("Blob " + blobName + " deleted Successfully"));
	}

}
