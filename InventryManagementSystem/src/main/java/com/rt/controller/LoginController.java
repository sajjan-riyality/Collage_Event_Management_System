package com.rt.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.rt.entity.User;
import com.rt.service.AuthService;

@Controller
public class LoginController {

    @Autowired
    private AuthService authService;

    @GetMapping("/loginPage")
    public String loginPage() {
        return "AuthPages/AuthLogin"; 
    }
    

    @PostMapping("/login")
    public String login(@RequestParam("exampleEmail") String email,
                        @RequestParam("examplePassword") String password,
                        HttpSession session) {
    	
    	

        Optional<User> userOptional = authService.authenticate(email, password);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            session.setAttribute("loggedInUser", user);
            
      Object   user1 =   session.getAttribute("userEmail");
            System.out.println(session.getAttribute(email));
            
            return authService.getRedirectUrlBasedOnRole(user);
        } else {
            return "redirect:/login?error=true";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login?logout=true";
    }
}
