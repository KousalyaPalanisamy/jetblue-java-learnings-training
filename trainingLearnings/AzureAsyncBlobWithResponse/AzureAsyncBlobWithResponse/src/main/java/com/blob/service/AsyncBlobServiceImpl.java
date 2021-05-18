package com.blob.service;

import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.azure.core.http.rest.Response;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.models.BlobProperties;
import com.azure.storage.blob.models.BlobRange;
import com.azure.storage.blob.models.BlockBlobItem;
import com.azure.storage.blob.models.DeleteSnapshotsOptionType;
import com.azure.storage.blob.models.DownloadRetryOptions;
import com.azure.storage.blob.options.BlobDownloadToFileOptions;
import com.azure.storage.blob.options.BlobUploadFromFileOptions;
import com.blob.exceptions.BlobException;

import reactor.core.publisher.Mono;

@Component
public class AsyncBlobServiceImpl 
{
	@Autowired
	BlobContainerAsyncClient blobContainerAsyncClient;
	
	public List<BlobItem> listAllBlobs() {
		return blobContainerAsyncClient.listBlobs()
				.doOnError(throwable -> {throw new BlobException("Failed", "Error Occurred while receiving list of Blobs");})
				.collectList().block();
	}

	public Response<BlockBlobItem> addBlobWithResponse(String filePath, String fileName, String directoryToUpload) 
	{	
		Mono<Response<BlockBlobItem>> response = blobContainerAsyncClient
						.getBlobAsyncClient(validFilePath(directoryToUpload)+fileName)
						.uploadFromFileWithResponse(new BlobUploadFromFileOptions(validFilePath(filePath)+fileName))
						.doOnError(throwable -> 
							{throw new BlobException("Failed", "No file found as '" + fileName + "' at '" + validFilePath(filePath)+"'");});
		return response.block();
	}
	
	public Response<BlobProperties> downloadBlobWithResponse(String blobName, String downloadToFilePath) {
		Mono<Response<BlobProperties>> response = blobContainerAsyncClient.getBlobAsyncClient(blobName)
					.downloadToFileWithResponse(new BlobDownloadToFileOptions(validFilePath(downloadToFilePath) + blobName)
					.setRange(new BlobRange(1024, 2018L))
					.setDownloadRetryOptions(new DownloadRetryOptions().setMaxRetryRequests(5))
					.setOpenOptions(new HashSet<>(Arrays.asList(StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE,
																StandardOpenOption.READ))))
					.doOnError(throwable -> {throw new BlobException("Failed", "No Such Blob available as " + blobName);});			    
		return response.block();
	}
	
	public Response<Void> deleteBlobWithResponse(String blobName) 
	{
		Mono<Response<Void>> response = blobContainerAsyncClient.getBlobAsyncClient(blobName)
						.deleteWithResponse(DeleteSnapshotsOptionType.INCLUDE, null)
						.doOnError(throwable -> {throw new BlobException("Failed", "No Such Blob available as " + blobName);});
		return response.block();
	}

	String validFilePath(String stringToAddSlash)
	{
		return (stringToAddSlash.endsWith("\\")) ? stringToAddSlash : stringToAddSlash+"\\";
	}
}
