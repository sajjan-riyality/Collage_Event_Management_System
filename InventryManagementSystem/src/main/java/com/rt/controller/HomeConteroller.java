package com.rt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeConteroller {

	@RequestMapping("/")
	public String indexPage() {
        return "index" ;
		
	}
	@RequestMapping("/userDashbord")
	public String Dashbord() {
        return "userDashbord" ;
		
	}
	
	

	// main admin pannal
	
	
	@RequestMapping("/createEvent")
	public String createEvent() {
        return "Admin/createEvent" ;
		
	}
	
	@RequestMapping("/generateCertificates")
	public String generateCertificates() {
		
		return "Admin/generateCertificates";
	}
	
	@GetMapping("/viewAllEvents")
	public String viewEvents() {
	    return "Admin/viewEvents";
	}

	@RequestMapping("/viewRegistrations")
	public String viewRegistrations() {
		
		return "Admin/viewRegistrations";
	}
	
	
      
	

}
