package com.blob.service;

import java.io.File;
import java.nio.file.InvalidPathException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azure.core.http.rest.Response;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.models.BlobProperties;
import com.azure.storage.blob.models.BlockBlobItem;

@Service
public class AsyncBlobService {
	@Autowired
	AsyncBlobServiceImpl blobService;

	public List<BlobItem> listAllBlobs() 
	{
		return blobService.listAllBlobs();
	}

	public Response<BlockBlobItem> addBlobWithResponse(String filePath, String fileName, String directoryToUpload) 
	{	
		return blobService.addBlobWithResponse(filePath, fileName, directoryToUpload);
	}
	
	public Response<BlobProperties> downloadBlobWithResponse(String blobName, String downloadToFilePath) 
	{
		if(new File(downloadToFilePath).isDirectory()) 
			return blobService.downloadBlobWithResponse(blobName, downloadToFilePath);
		else 
			throw new InvalidPathException(downloadToFilePath, "Invalid Path");
	}

	public Response<Void> deleteBlobWithResponse(String blobName) 
	{
		return blobService.deleteBlobWithResponse(blobName);
	}

	String validFilePath(String stringToAddSlash)
	{
		return (stringToAddSlash.endsWith("\\")) ? stringToAddSlash : stringToAddSlash+"\\";
	}

	
}
