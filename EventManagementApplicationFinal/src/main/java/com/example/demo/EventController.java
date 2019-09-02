package com.example.demo;





import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eventmgr.controller.EveeentController;
import com.eventmgr.model.Event;
import com.eventmgr.repositaries.EventRepositary;
import com.google.gson.Gson;


@RestController
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
	
	@GetMapping("/selectRequestEvents")
	public List<Event> selctRequestEvent(HttpServletRequest request) {
		EveeentController ev= new EveeentController();
		List<Event> evlst = new ArrayList<Event>();
		evlst=ev.getRequestedEvent();
		return evlst;
	}

	@GetMapping("/selectPendingEvent")
	public List<Event> getPendingEvent() {
		
		EveeentController ev= new EveeentController();
		List<Event> evlst = new ArrayList<Event>();
		evlst=ev.getPendingEvent();
		return evlst;
		
	}
	
	@RequestMapping("/selectConfirmedEvent")
	public List<Event> getConfirmedEvent() {
		
		EveeentController ev= new EveeentController();
		List<Event> evlst = new ArrayList<Event>();
		evlst=ev.getConfirmedEvent();
		return evlst;
		
	}
}
