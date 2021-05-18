package com.blob.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azure.core.http.rest.PagedIterable;
import com.azure.storage.blob.models.BlobItem;
import com.blob.service.BlobService;

@RestController
public class BlobController 
{
	@Autowired
	BlobService blobService;
	
	@GetMapping("/blobs")
	public ResponseEntity<PagedIterable<BlobItem>> listAllBlobs()
	{
		return new ResponseEntity<>(blobService.listAllBlobs(),HttpStatus.OK);
	}
	
	@PostMapping("/blob")
	public ResponseEntity<Void> uploadNewBlob(@RequestParam String filePath, @RequestParam String fileName)
	{
		blobService.addBlob(filePath, fileName);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/blob/{name}")
	public ResponseEntity<Void> downloadBlob(@PathVariable(value="name") String blobName, @RequestParam String filePathToDownload)
	{
		blobService.downloadBlob(blobName, filePathToDownload);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/blob/{name}")
	public ResponseEntity<Void> deleteBlob(@PathVariable(value="name") String blobName)
	{
		blobService.deleteBlob(blobName);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
