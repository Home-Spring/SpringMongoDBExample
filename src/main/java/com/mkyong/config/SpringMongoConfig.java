package com.mkyong.config;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.util.Arrays;

/**
 * Spring MongoDB configuration file
 */
@Configuration
public class SpringMongoConfig{

    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        // Set credentials
        MongoCredential  credential = MongoCredential.createCredential("admin", "test", "1978".toCharArray()); // mongodb://admin:1978@127.0.0.1:27017/test
        ServerAddress serverAddress = new ServerAddress("localhost", 27017);

        // Mongo Client
        MongoClient mongoClient = new MongoClient(serverAddress, Arrays.asList(credential));

        // Mongo DB Factory
        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, "test");

        return simpleMongoDbFactory;
    }

	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}
		
}