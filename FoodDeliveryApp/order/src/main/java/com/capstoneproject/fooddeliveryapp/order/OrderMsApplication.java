package com.capstoneproject.fooddeliveryapp.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;



@SpringBootApplication
@EnableMongoRepositories
public class OrderMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMsApplication.class, args);
	
//		try {
//			//URI i.e Connection String to make connection to the MongoDB
//			String mongoDBURI="mongodb+srv://riwajrai:<riwajrai>@cluster0.ot68e.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
//
//			
//			//1. Connect to MongoDB
//			MongoClient client = MongoClients.create(mongoDBURI); 
//			System.out.println("Connection Created Successfully.");
//			
//			System.out.println("Database Names: ");
//			System.out.println(client.listDatabaseNames());
//			
//		} catch (Exception e) {
//			System.out.println("Something Went Wrong.");
//			System.out.println("Message: "+e.getMessage());
//		}
//		
//		
//	
	}
	
	@Bean

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
