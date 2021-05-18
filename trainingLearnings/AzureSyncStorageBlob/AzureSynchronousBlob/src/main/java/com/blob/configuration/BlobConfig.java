package com.blob.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;

@Configuration
public class BlobConfig 
{
	@Value("${azure.connectionString}")
	private String connectionString;
	@Value("${azure.storage.account_url}")
	String storageAcccountUrl;
	@Value("${azure.storage.SASToken}")
	String sasToken;
	@Value("${azure.storage.containerName}")
	String containerName;
	
	@Bean
	public BlobContainerClient blobContainerClient() {
		return new BlobContainerClientBuilder()
		    .endpoint(storageAcccountUrl)
		    .sasToken(sasToken)
		    .containerName(containerName)
		    .buildClient();
	}
	
	@Bean
	public BlobServiceClient blobServiceClient() {
			return new BlobServiceClientBuilder()
					.endpoint(storageAcccountUrl)
				    .sasToken(sasToken)					
					.buildClient();
			
	}
}
