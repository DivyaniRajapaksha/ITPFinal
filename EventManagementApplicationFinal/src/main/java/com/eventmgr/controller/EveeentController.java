package com.eventmgr.controller;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.google.gson.Gson;
import com.eventmgr.model.Event;
import com.eventmgr.repositaries.EventRepositary;
import com.google.gson.Gson;
//import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator;
//import org.apache.tomcat.util.json.JSONParser;
import java.util.List;

import com.mongodb.MongoClient; 
import com.mongodb.MongoCredential;

/*import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;*/

import com.mongodb.client.FindIterable; 

@Controller
public class EveeentController {
	
	public void createEvent(Event event) {
		 MongoClient mongo = new MongoClient( "localhost" , 27017 );
	    
	     MongoCredential credential; 
	     credential = MongoCredential.createCredential("EventManagement",      "eventManagementDb", 
	    "password".toCharArray()); 
	     System.out.println("Connected to the database successfully");  
	     MongoDatabase database = mongo.getDatabase("eventManagementDb");
	     MongoCollection<Document> collection =      database.getCollection("eventCollection"); 
	     System.out.println("Collection examplesCollection selected successfully");
	     Document document = new Document("ename", event.getEname()) 
	     .append("elocation", event.getElocation())
	     .append("etype",event.getEtype()) 
	     .append("ephoneNo",event.getEphoneNo()) 
	     .append("edate",event.getEdate()) 
	     .append("etime",event.getEtime())
	     .append("estatus",event.getEstatus()); 
	     collection.insertOne(document); 
	     System.out.println("Document inserted successfully"); 
	   } 
	
	
	
	public List<Event> getAllEvent() {
	 String str="";
	 MongoClient mongo = new MongoClient( "localhost" , 27017 );
	   MongoCredential credential;
	   credential = MongoCredential.createCredential("EventManagement",    "eventManagementDb", 
	   "password".toCharArray()); 
	   System.out.println("Connected to the database successfully");  
	   MongoDatabase database = mongo.getDatabase("eventManagementDb");  
	   MongoCollection<Document> collection =    database.getCollection("eventCollection");
	   System.out.println("Collection examplesCollection selected successfully");
	   FindIterable<Document> iterDoc = collection.find(); 
	   int i = 1;
	   ArrayList<Event> evlst = new ArrayList<Event>();
	   Iterator it = iterDoc.iterator(); 
	   while (it.hasNext()) { 
		   String txt=((it.next().toString().replace("{{", "{\"")).replace("}}", "\"}")).replace("Document", "");
		   txt=((txt.replace("=", "\":\"")).replace(",", "\",\""));
		   txt=txt.replace(",\" ", ",\"");
	   System.out.println(txt); 
	   Gson g = new Gson();
	  // String tt="{_id=5d689d48eed0221aac329a6b/ename=divya/elocation=wariyapola/etype=Birthday Parties/ephoneNo=0718505103/edate=2019-08-28, etime=10.0, estatus=request}";
	   Event p = g.fromJson(txt, Event.class);
	   System.err.println(p.getEname());
	   evlst.add(p);
	   i++; 
	   }
	   for(Event p:evlst){
		   System.err.println("yyyyy"+p.getElocation());
	   }
	return evlst;
	 }

	public void deleteEvent(String id) {
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
     	
		MongoCredential credential; 
		credential = MongoCredential.createCredential("examplesUser", "examplesDb", 
		"password".toCharArray()); 
		System.out.println("Connected to the database successfully");
    
		MongoDatabase database = mongo.getDatabase("examplesDb");
    	
		MongoCollection<Document> collection =       database.getCollection("eventCollection");
		System.out.println("Collection examplesCollection selected successfully");
   
		collection.deleteOne(Filters.eq("id", id)); 
		System.out.println("Document deleted successfully..."); 
		
	}
	public List<Event> getRequestedEvent() {
		 String str="";
		 MongoClient mongo = new MongoClient( "localhost" , 27017 );
		   MongoCredential credential;
		   credential = MongoCredential.createCredential("EventManagement",    "eventManagementDb", 
		   "password".toCharArray()); 
		   System.out.println("Connected to the database successfully");  
		   MongoDatabase database = mongo.getDatabase("eventManagementDb");  
		   MongoCollection<Document> collection =    database.getCollection("eventCollection");
		   System.out.println("Collection examplesCollection selected successfully");
		   
		   
		   FindIterable<Document> iterDoc = collection.find(Filters.eq("estatus", "request")); 
		   int i = 1;
		   ArrayList<Event> evlst = new ArrayList<Event>();
		   Iterator it = iterDoc.iterator(); 
		   while (it.hasNext()) { 
			   String txt=((it.next().toString().replace("{{", "{\"")).replace("}}", "\"}")).replace("Document", "");
			   txt=((txt.replace("=", "\":\"")).replace(",", "\",\""));
			   txt=txt.replace(",\" ", ",\"");
		   System.out.println(txt); 
		   Gson g = new Gson();
		  // String tt="{_id=5d689d48eed0221aac329a6b/ename=divya/elocation=wariyapola/etype=Birthday Parties/ephoneNo=0718505103/edate=2019-08-28, etime=10.0, estatus=request}";
		   Event p = g.fromJson(txt, Event.class);
		   System.err.println(p.getEname());
		   evlst.add(p);
		   i++; 
		   }
		   for(Event p:evlst){
			   System.err.println("yyyyy"+p.getElocation());
		   }
		return evlst;
		 }
	
	
	public List<Event> getPendingEvent() {
		 String str="";
		 MongoClient mongo = new MongoClient( "localhost" , 27017 );
		   MongoCredential credential;
		   credential = MongoCredential.createCredential("EventManagement",    "eventManagementDb", 
		   "password".toCharArray()); 
		   System.out.println("Connected to the database successfully");  
		   MongoDatabase database = mongo.getDatabase("eventManagementDb");  
		   MongoCollection<Document> collection =    database.getCollection("eventCollection");
		   System.out.println("Collection examplesCollection selected successfully");
		   
		   
		   FindIterable<Document> iterDoc = collection.find(Filters.eq("estatus", "pending")); 
		   int i = 1;
		   ArrayList<Event> evlst = new ArrayList<Event>();
		   Iterator it = iterDoc.iterator(); 
		   while (it.hasNext()) { 
			   String txt=((it.next().toString().replace("{{", "{\"")).replace("}}", "\"}")).replace("Document", "");
			   txt=((txt.replace("=", "\":\"")).replace(",", "\",\""));
			   txt=txt.replace(",\" ", ",\"");
		   System.out.println(txt); 
		   Gson g = new Gson();
		  // String tt="{_id=5d689d48eed0221aac329a6b/ename=divya/elocation=wariyapola/etype=Birthday Parties/ephoneNo=0718505103/edate=2019-08-28, etime=10.0, estatus=request}";
		   Event p = g.fromJson(txt, Event.class);
		   System.err.println(p.getEname());
		   evlst.add(p);
		   i++; 
		   }
		   for(Event p:evlst){
			   System.err.println("yyyyy"+p.getElocation());
		   }
		return evlst;
		 }
	
	
	public List<Event> getConfirmedEvent() {
		 String str="";
		 MongoClient mongo = new MongoClient( "localhost" , 27017 );
		   MongoCredential credential;
		   credential = MongoCredential.createCredential("EventManagement",    "eventManagementDb", 
		   "password".toCharArray()); 
		   System.out.println("Connected to the database successfully");  
		   MongoDatabase database = mongo.getDatabase("eventManagementDb");  
		   MongoCollection<Document> collection =    database.getCollection("eventCollection");
		   System.out.println("Collection examplesCollection selected successfully");
		   
		   
		   FindIterable<Document> iterDoc = collection.find(Filters.eq("estatus", "confirm")); 
		   int i = 1;
		   ArrayList<Event> evlst = new ArrayList<Event>();
		   Iterator it = iterDoc.iterator(); 
		   while (it.hasNext()) { 
			   String txt=((it.next().toString().replace("{{", "{\"")).replace("}}", "\"}")).replace("Document", "");
			   txt=((txt.replace("=", "\":\"")).replace(",", "\",\""));
			   txt=txt.replace(",\" ", ",\"");
		   System.out.println(txt); 
		   Gson g = new Gson();
		  // String tt="{_id=5d689d48eed0221aac329a6b/ename=divya/elocation=wariyapola/etype=Birthday Parties/ephoneNo=0718505103/edate=2019-08-28, etime=10.0, estatus=request}";
		   Event p = g.fromJson(txt, Event.class);
		   System.err.println(p.getEname());
		   evlst.add(p);
		   i++; 
		   }
		   for(Event p:evlst){
			   System.err.println("yyyyy"+p.getElocation());
		   }
		return evlst;
		 }

}
	
	


