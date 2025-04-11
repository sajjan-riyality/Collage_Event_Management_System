package com.rt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rt.service.EventService;

@Controller
public class UserAdminController {
	
	@Autowired
    private EventService eventService;

	 
	@RequestMapping("/availableEvents")
	public String availableEvents() {
		
		return "User/availableEvents.jsp";
	}
	
	@RequestMapping("/myCertificates")
	public String myCertificates() {
		
		return "User/myCertificates";
	}
	
//	@RequestMapping("/myRegistrations")
//	public String myRegistrations() {
//		
//		return "User/myRegistrations";
//	}
	
	@RequestMapping("/eventRegistration")
	public String eventRegistration(Model model) {
		
		  model.addAttribute("availableEvents", eventService.getAllEvents());
		
		return "User/eventRegistration";
	}

}
