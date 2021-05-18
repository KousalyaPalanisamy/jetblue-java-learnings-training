package com.cosmos.configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.azure.core.credential.AzureKeyCredential;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.DirectConnectionConfig;
import com.azure.cosmos.GatewayConnectionConfig;
import com.azure.spring.data.cosmos.config.AbstractCosmosConfiguration;
import com.azure.spring.data.cosmos.config.CosmosConfig;
import com.azure.spring.data.cosmos.repository.config.EnableCosmosRepositories;

@Configuration
@EnableCosmosRepositories("com.cosmos.repository")
public class StudentConfig extends AbstractCosmosConfiguration {

    @Value("${azure.cosmos.uri}")
    private String uri;

    @Value("${azure.cosmos.key}")
    private String key;

    @Value("${azure.cosmos.database}")
    private String dbName;

    @Value("${azure.cosmos.populate-query-metrics}")
    private boolean queryMetricsEnabled;
    
    @Bean
    public CosmosClientBuilder getCosmosClientBuilder() {
    	//to authorize the requests
    	AzureKeyCredential azureKeyCredential = new AzureKeyCredential(key);
    	//connection config with DIRECT associated with Cosmos Client in the Azure Cosmos DB
    	//equests to server resources are made directly to the data nodes.
        DirectConnectionConfig directConnectionConfig = new DirectConnectionConfig();
        //requests to server resources are made through a gateway proxy using HTTPS
        GatewayConnectionConfig gatewayConnectionConfig = new GatewayConnectionConfig();
        return new CosmosClientBuilder()
            .endpoint(uri)
            .credential(azureKeyCredential)
            .directMode(directConnectionConfig, gatewayConnectionConfig);
    }

    @Override
    // configures the properties of cosmos database
    public CosmosConfig cosmosConfig() {
        return CosmosConfig.builder()
                           .enableQueryMetrics(queryMetricsEnabled)
                           .build();
    }



    @Override
    protected String getDatabaseName() {
        return dbName;
    }
  
}