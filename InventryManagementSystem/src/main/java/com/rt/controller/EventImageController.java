package com.rt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rt.entity.Event;
import com.rt.entity.EventImage;
import com.rt.repository.EventImageRepository;
import com.rt.service.EventImageService;
import com.rt.service.EventService;

@Controller
public class EventImageController {
	
	
	@Autowired
	EventService eventService ;
	
	@Autowired
	EventImageService eventImageService ;
	
	@Autowired
	EventImageRepository eventImageRepository ;
	
	
	
	@PostMapping("/saveEvent")
	public String saveEvent(@ModelAttribute Event event,
	                        @RequestParam("file") MultipartFile file,
	                        Model model) {
		
		
		
		
		try {
	    
	    System.out.println(event.getId());
	    
	        eventImageService.uploadImage(file,event);
	        model.addAttribute("message", "Image uploaded successfully!");
	        model.addAttribute("id", event.getId());
	        System.out.println("uploaded successfully");
	        return "redirect:/admin/viewEvents";

	    } catch (IOException e) {
	    	 model.addAttribute("message", "Upload failed.");
	        e.printStackTrace();
	    }
	    return "redirect:/admin/createEvent";
	}
	
	
//	@GetMapping("/images")
//	public String showImages(Model model) {
//	    List<EventImage> images = eventImageRepository.findAll();
//	    model.addAttribute("images", images);
//	    return "image_list"; // your JSP page name
//	}
	
	@GetMapping("/event/imageById")
	public String getImageByEventId(@ModelAttribute Event event, Model model) {
	    Optional<EventImage> imageOpt = eventImageRepository.findByEventId(event.getId());
	    
	    if (imageOpt.isPresent()) {
	        model.addAttribute("image", imageOpt.get());
	        System.out.println(imageOpt.isPresent());
	    } else {
	        model.addAttribute("error", "No image found for this event.");
	    }

	    return "Admin/viewEvents"; // your JSP page
	}
	
	@GetMapping("/admin/viewEvents")
	public String viewEvents(Model model) {
	    List<Event> events = eventService.getAllEvents();
	    System.out.println(events.isEmpty());
	    
	    model.addAttribute("events", events);
	    return "Admin/viewEvents";
	}



	
}

