package com.rt.service;

import com.rt.entity.Event;
import com.rt.entity.EventImage;
import com.rt.repository.EventImageRepository;
import com.rt.repository.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Service
public class EventImageService {

    private final String uploadDir = "src/main/webapp/images/";

    @Autowired
    private EventImageRepository eventImageRepository;
    
    @Autowired
    private EventRepository eventRepository ;

//    public void uploadImage(MultipartFile file, Event event) throws IOException {
//        String fileName = file.getOriginalFilename();
//        File saveFile = new File(uploadDir + fileName);
//        file.transferTo(saveFile);
//
//        EventImage eventImage = new EventImage("/images/" + fileName, event);
//        eventImageRepository.save(eventImage);
//    }
    


    public String uploadImage(MultipartFile file,@ModelAttribute Event event) throws IOException {
        // Set proper upload path
        String uploadDir = new File("uploads/images").getAbsolutePath();
        
        
        
        
        // Save Event first
        Event savedEvent = eventRepository.save(event);
        
        
        
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Replace spaces to avoid issues
        String fileName = file.getOriginalFilename().replaceAll("\\s+", "_");

        // Save file
        File serverFile = new File(uploadDir + File.separator + fileName);
        file.transferTo(serverFile);
        
     // Save image name or path to DB
//        EventImage eventImage = new EventImage();
//        eventImage.setImageUrl(fileName); // or full path if needed
//        eventImageRepository.save(eventImage);
        
     // Save EventImage entity
        EventImage eventImage = new EventImage();
        eventImage.setImageUrl(fileName);
        eventImage.setEvent(savedEvent);
        eventImageRepository.save(eventImage);

        return "Image uploaded successfully: " + fileName;
    }
}
