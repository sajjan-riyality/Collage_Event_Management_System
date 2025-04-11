package com.rt.controller;

import com.rt.entity.Event;
import com.rt.entity.RegistrationDTO;
import com.rt.repository.RegistrationDetailsDTO;
import com.rt.service.EventService;
import com.rt.service.RegistrationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    @Autowired
    private EventService eventService;

    @Autowired
    private RegistrationService registrationService;

   
    @GetMapping("/createEventForm")
    public String showCreateEventForm(Model model) {
        model.addAttribute("event", new Event());
        return "admin/create_event";  // JSP: /WEB-INF/views/admin/create_event.jsp
    }

//    // 2. Save Event
//    @PostMapping("/saveEvent")
//    public String saveEvent(@ModelAttribute Event event) {
//        eventService.saveEvent(event);  // Corrected method name
//        return "redirect:/allEvents";
//    }
    
  

    // 3. View All Events
    @GetMapping("/allEvents")
    public String viewAllEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents()); 
        return "Admin/viewEvents";  
    }

//    // 4. View All Registrations
//    @GetMapping("/registrations")
//    public String viewRegistrations(Model model) {
//        model.addAttribute("registrations", registrationService.getAllRegistrations());
//        return "Admin/viewRegistrations";  
//    }
    
    
    @GetMapping("/registrations")
    public String viewRegistrations(Model model) {
        List<RegistrationDTO> dtos = registrationService.getRegistrationsByUser();
        model.addAttribute("registrations", dtos);
        return "viewRegistrations";
    }

    // 5. Generate Certificates
    @PostMapping("/generateCertificates")
    public String generateCertificates() {
        registrationService.generateCertificates(); 
        return "redirect:/viewRegistrations";
    }
}
