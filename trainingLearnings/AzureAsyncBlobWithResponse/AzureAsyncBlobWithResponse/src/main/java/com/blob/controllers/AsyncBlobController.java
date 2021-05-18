package com.blob.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azure.core.http.rest.Response;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.models.BlobProperties;
import com.azure.storage.blob.models.BlockBlobItem;
import com.blob.service.AsyncBlobService;

@RestController
public class AsyncBlobController 
{
	@Autowired
	AsyncBlobService blobService;
	
	@GetMapping("/blobs")
	public ResponseEntity<List<BlobItem>> listAllBlobs()
	{
		return new ResponseEntity<>(blobService.listAllBlobs(),HttpStatus.OK);
	}
	
	@PostMapping("/blobWithResponse")
	public ResponseEntity<Response<BlockBlobItem>> uploadNewBlobwithResponse(@RequestParam String filePath, @RequestParam String fileName, @RequestParam(defaultValue ="", required = false) String directoryToUpload)
	{
		Response<BlockBlobItem> response = blobService.addBlobWithResponse(filePath, fileName, directoryToUpload);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}
	
	@GetMapping("/blobWithResponse/{blobName}")
	public ResponseEntity<Response<BlobProperties>> downloadBlobWithResponse(@PathVariable(value="blobName") String blobName, @RequestParam String filePathToDownload)
	{
		Response<BlobProperties> response = blobService.downloadBlobWithResponse(blobName, filePathToDownload);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}	
	
	@DeleteMapping("/blobWithResponse/{blobName}")
	public ResponseEntity<Response<Void>> deleteBlobWithResponse(@PathVariable(value="blobName") String blobName)
	{
		Response<Void> response = blobService.deleteBlobWithResponse(blobName);
		return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
	}
	
	
}
