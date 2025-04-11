package com.rt.controller;

import com.rt.entity.Event;
import com.rt.entity.EventRegistration;
import com.rt.entity.Registration;
import com.rt.entity.RegistrationDTO;
import com.rt.entity.User;
import com.rt.service.EventService;
import com.rt.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private EventService eventService;

    // Show registration form
//    @GetMapping("/register")
//    public String showRegistrationForm(Model model) {
//        List<Event> events = eventService.getAllEvents(); // For dropdown selection
//        model.addAttribute("events", events);
//        return "User/registrationForm"; // JSP: /WEB-INF/views/User/registrationForm.jsp
//    }

//    // Handle registration (form submission)
//    @PostMapping("/register")
//    public String registerUserToEvent(@RequestParam Long userId,
//                                      @RequestParam Long eventId,
//                                      Model model) {
//        Registration registration = registrationService.registerUserToEvent(userId, eventId);
//        model.addAttribute("registration", registration);
//        model.addAttribute("success", "User registered successfully!");
//        return "User/registrationSuccess"; // JSP: /WEB-INF/views/User/registrationSuccess.jsp
//    }
//    
    

//    @PostMapping("/registerEvent")
//    public String registerEvent(@RequestParam String name,
//                                @RequestParam String email,
//                                @RequestParam String phone,
//                                @RequestParam(required = false) String comments,
//                                @RequestParam Long eventId,
//                                HttpSession session,
//                                Model model) {
//    	
//    	
//
//    	 Object   user1 =   session.getAttribute("userEmail");
//         System.out.println(user1);
//
//    	// Get the email/username string
//    	String userEmailOrUsername = (String) session.getAttribute("loggedInUser");
//
//    	if (userEmailOrUsername == null) {
//    	    return "redirect:/login";
//    	}
//
//    	// Save registration
//    	List<RegistrationDTO> registrations = registrationService.saveRegistration(
//    	    name, email, phone, comments, eventId, userEmailOrUsername
//    	);
//
//    	model.addAttribute("registrations", registrations);
//    	return "registration_success";
//
//    }
    
    
    @PostMapping("/registerEvent")
    public String registerEvent(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String phone,
                                @RequestParam(required = false) String comments,
                                @RequestParam("eventId") Long eventId,
                                HttpSession session,
                                Model model) {

        // Get the logged-in user object from session
        User user = (User) session.getAttribute("loggedInUser");

        // Check if user is not logged in
        if (user == null) {
            return "redirect:/loginPage"; 
        }

        Long userId = user.getId();              // Now safe
        String userEmail = user.getEmail();      // Extract email from User object

        System.out.println("User ID: " + userId);

        // Save registration
        List<RegistrationDTO> registrations = registrationService.saveRegistration(
            name, email, phone, comments, eventId, userEmail
        );

        model.addAttribute("registrations", registrations);
        return "User/eventRegistration";
    }
       
    
//    @GetMapping("/EventRegistrations")
//    public String viewEventRegistrations(Model model) {
//        model.addAttribute("registrations", registrationService.getAllRegistrations());
//        return "User/myRegistrations"; // JSP file name
//    }
    
    
    @GetMapping("/EventRegistrations")
    public String viewEventRegistrations(Model model) {
        System.out.println("EventRegistrations running ...!");

        long eventId = 6; // Change this to the correct event ID
        List<RegistrationDTO> registrations = registrationService.getStudentsByEventId(eventId);

        model.addAttribute("registrations", registrations);

        return "User/myRegistrations"; // JSP file
    }
    
//    @GetMapping("/EventRegistrations/hell")
//    public String showAllRegistrations(Model model) {
//        List<Registration> registrations = registrationService.getAllRegistrations();
//        model.addAttribute("registrations", registrations);
//        return "User/myRegistrations";  // JSP page name
//    }
   

    @GetMapping("/myRegistrations")
    public String getMyRegistrations(HttpSession session, Model model) {
        User user = (User) session.getAttribute("loggedInUser");

        if (user != null) {
            List<RegistrationDTO> registrations = registrationService.getRegistrationsByUserId(user.getId());
            model.addAttribute("registrations", registrations);
            return "User/myRegistrations"; // JSP page
        } 
        else {
            return "User/myRegistrations";
        }
    }



//    // Show all events a user has registered for
//    @GetMapping("/user/{userId}/events")
//    public String getEventsByUser(@PathVariable Long userId, Model model) {
//        List<Event> events = registrationService.getEventsByUserId(userId);
//        model.addAttribute("events", events);
//        model.addAttribute("userId", userId);
//        return "User/viewMyEvents"; // JSP: /WEB-INF/views/User/viewMyEvents.jsp
//    }

//    // Admin: View all registrations
//    @GetMapping("/admin/registrations")
//    public String getAllRegistrations(Model model) {
//        List<Registration> registrations = registrationService.getAllRegistrations();
//        model.addAttribute("registrations", registrations);
//        return "Admin/viewRegistrations"; // JSP: /WEB-INF/views/Admin/viewRegistrations.jsp
//    }
}
