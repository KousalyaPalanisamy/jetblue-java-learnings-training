package com.blob.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobContainerClientBuilder;

@Configuration
public class AsyncBlobConfig 
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
	public BlobContainerAsyncClient blobContainerClient() {
		return new BlobContainerClientBuilder()
		    .endpoint(storageAcccountUrl)
		    .sasToken(sasToken)
		    .containerName(containerName)
		    .buildAsyncClient();
	}
	
}
