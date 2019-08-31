package com.eventmgr.controller;

import org.bson.Document;
import org.springframework.stereotype.Controller;

import com.eventmgr.model.Supplier;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Controller
public class SupplierController {
	
	public void createSupplier(Supplier supplier) {
		 MongoClient mongo = new MongoClient( "localhost" , 27017 );
	    
	     MongoCredential credential; 
	     credential = MongoCredential.createCredential("EventManagement",      "eventManagementDb", 
	    "password".toCharArray()); 
	     System.out.println("Connected to the database successfully"); 
	     MongoDatabase database = mongo.getDatabase("eventManagementDb");
	     MongoCollection<Document> collection =      database.getCollection("supplierCollection"); 
	     System.out.println("Collection examplesCollection selected successfully");
	     Document document = new Document("companyName", supplier.getCompanyName()) 
	     .append("website", supplier.getWebsite())
	     .append("address",supplier.getAddress()) 
	     .append("companyPhneNo",supplier.getCompanyPhneNo()) 
	     .append("fName",supplier.getfName()) 
	     .append("lName",supplier.getlName())
	     .append("email",supplier.getEmail())
	     .append("nic",supplier.getNic()); 
	     collection.insertOne(document); 
	     System.out.println("Document inserted successfully"); 
	   } 
	
	
}
