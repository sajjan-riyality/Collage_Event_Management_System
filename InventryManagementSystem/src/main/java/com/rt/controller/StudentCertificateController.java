package com.rt.controller;

import com.rt.entity.Registration;
import com.rt.entity.RegistrationDTO;
import com.rt.entity.User;
import com.rt.service.CertificateService;
import com.rt.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StudentCertificateController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private CertificateService certificateService;

    // Show all certificates for the logged-in student
    @GetMapping("/myCertificates")
    public String viewMyCertificates(Model model, HttpSession session) {
    	// Get the logged-in user object from session
        User user = (User) session.getAttribute("loggedInUser");

        // Check if user is not logged in
        if (user == null) {
            return "redirect:/loginPage"; 
        }

        Long userId = user.getId(); 

       

        List<RegistrationDTO> myRegistrations = registrationService.getRegistrationsByUserId(userId);
        model.addAttribute("registrations", myRegistrations);

        return "User/myCertificates"; 
    }
    
    
    
    
    @GetMapping("/downloadCertificate/{registrationId}")
    public ResponseEntity<InputStreamResource> downloadCertificate(@PathVariable Long registrationId) {
        var bis = certificateService.generateCertificate(registrationId);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=certificate_" + registrationId + ".pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
