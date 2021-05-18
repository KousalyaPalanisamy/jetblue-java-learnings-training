package com.blob.service;

import java.io.UncheckedIOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.models.BlobStorageException;
import com.blob.exceptions.BlobException;

@Service
public class BlobService {
	@Autowired
	BlobContainerClient blobContainerClient;

	public PagedIterable<BlobItem> listAllBlobs() {
		return blobContainerClient.listBlobs();
	}

	public void addBlob(String filePath, String fileName) {
		try {
			blobContainerClient.getBlobClient(fileName).uploadFromFile(filePath + fileName);
		} catch (UncheckedIOException e) {
			throw new UncheckedIOException("Failed to upload the blob " + fileName, e.getCause());
		}
	}

	public void downloadBlob(String blobName, String downloadToFilePath) {
		try {
			blobContainerClient.getBlobClient(blobName).downloadToFile(downloadToFilePath + blobName);
		} catch (BlobStorageException e) {
			throw new BlobException("Failed", "No blob available as " + blobName);
		}
	}

	public void deleteBlob(String blobName) {
		try {
			blobContainerClient.getBlobClient(blobName).delete();
		} catch (BlobStorageException e) {
			throw new BlobException("Failed", "No blob available as " + blobName);
		}
	}
}
