 package com.rt.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.rt.entity.Event;
import com.rt.entity.Registration;
import com.rt.service.EventService;
import com.rt.service.RegistrationService;

import java.util.List;

@Controller
public class StudentEventController {

    @Autowired
    private EventService eventService;
    
    @Autowired
    private RegistrationService registrationService;

    

    // Show Registration Form
    @GetMapping("/availableEvents")
    public String availableEvents(Model model) {
    	model.addAttribute("events", eventService.getAllEvents()); 
        return "User/availableEvents"; 
    }
    

   
//    @PostMapping("/create")
//    public Event createEvent(@RequestBody Event event) {
//        return eventService.saveEvent(event);
//    }
//    
//    @PutMapping("/update/{id}")
//    public Event updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
//        return eventService.updateEvent(id, updatedEvent);
//    }

   
//    @GetMapping
//    public List<Event> getAllEvents() {
//    	
//    	List<Event> list = eventService.getAllEvents();
//    	System.out.println(list.isEmpty());
//        return eventService.getAllEvents();
//    }

 
    @GetMapping
    public String viewRegistrations(Model model) {
        List<Registration> registrations = registrationService.getAllRegistrations();
        model.addAttribute("registrations", registrations);
        return "registration-list"; 
    }



    @GetMapping("/viewEvents")
    public String viewEvents(Model model) {
        List<Event> events = eventService.getAllEvents(); // or findAllWithImages()
       System.out.println( events.isEmpty());
        model.addAttribute("events", events);
        return "Admin/viewEvents"; // JSP Page
    }


   
//    @DeleteMapping("/{id}")
//    public String deleteEvent(@PathVariable Long id) {
//        eventService.deleteEvent(id);
//        return "Event deleted successfully!";
//    }
}
