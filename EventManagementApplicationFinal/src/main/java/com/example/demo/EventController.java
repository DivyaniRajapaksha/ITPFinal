package com.example.demo;





import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


import com.eventmgr.controller.EveeentController;
import com.eventmgr.model.Event;
import com.eventmgr.repositaries.EventRepositary;



@Controller
public class EventController {
	
	@RequestMapping("home")
	public String home1() {
		
		return "home.jsp";
	}
	
	@RequestMapping("index")
	public String home() {
		
		return "index.html";
	}
	
	@RequestMapping("/addEvent")
	public String addevent(Event events) {
		
		System.out.println("Hiii");
		System.out.println(events.getEname());
		System.out.println(events.getElocation());
		System.out.println(events.getEphoneNo());
		System.out.println(events.getEtime());
		System.out.println(events.getEtype());
		System.out.println(events.getEdate());
		EveeentController ev= new EveeentController();
		ev.createEvent(events);
		return "index.html";
	}
	
	@RequestMapping("eventManagement")
	public String dashhboard() {
		
		return "eventManagement.html";
	}
	
	@RequestMapping("/selectAllEvents")
	public String selctEvent() {
		
		System.out.println("Hiii");
		
		EveeentController ev= new EveeentController();
		ev.getAllEvent();
		
		return "event.html";
		
	}
	
	@RequestMapping("/selectRequestEvents")
	public List<Event> selctRequestEvent() {
		
		System.out.println("Hiii Request");
		
		EveeentController ev= new EveeentController();
		ev.getRequestedEvent();
		List<Event> evlst = new ArrayList<Event>();
		evlst=ev.getRequestedEvent();
		System.out.println();
		return evlst;
		
	}

	@RequestMapping("/selectPendingEvent")
	public String getPendingEvent() {
		
		System.out.println("Hiii Pending");
		
		EveeentController ev= new EveeentController();
		ev.getPendingEvent();
		
		return "event.html";
		
	}
	
	@RequestMapping("/selectConfirmedEvent")
	public String getConfirmedEvent() {
		
		System.out.println("Hiii Confirmed");
		
		EveeentController ev= new EveeentController();
		ev.getConfirmedEvent();
		
		return "event.html";
		
	}
}
