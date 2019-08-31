package com.eventmgr.controller;





import org.bson.Document;

import org.springframework.stereotype.Controller;


import com.eventmgr.model.Customer;


import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Controller
public class CustomerController {
	public void createCustomer(Customer customer) {
		 MongoClient mongo = new MongoClient( "localhost" , 27017 );
	    
	     MongoCredential credential; 
	     credential = MongoCredential.createCredential("EventManagement",      "eventManagementDb", 
	    "password".toCharArray()); 
	     System.out.println("Connected to the database successfully"); 
	     MongoDatabase database = mongo.getDatabase("eventManagementDb");
	     MongoCollection<Document> collection =      database.getCollection("customerCollection"); 
	     System.out.println("Collection examplesCollection selected successfully");
	     Document document = new Document("email", customer.getEmail()) 
	     .append("nic", customer.getNic())
	     .append("fName",customer.getfName()) 
	     .append("lName",customer.getlName()) 
	     .append("address",customer.getAddress()) 
	     .append(" phneNo",customer.getPhneNo()); 
	     collection.insertOne(document); 
	     System.out.println("Document inserted successfully"); 
	   } 
	
	
}
