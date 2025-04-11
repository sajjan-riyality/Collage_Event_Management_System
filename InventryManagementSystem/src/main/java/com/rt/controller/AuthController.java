package com.rt.controller;

import com.rt.entity.Role;
import com.rt.entity.RoleType;
import com.rt.entity.User;
import com.rt.service.AuthService;
import com.rt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthService authService ;

  
    
    @GetMapping("/registerPage")
    public String registerPage() {
        return "AuthPages/AuthRegister"; 
    }

//    @PostMapping("/login")
//    public String login(@RequestParam(name = "exampleEmail") String email,
//                        @RequestParam(name = "examplePassword") String password,
//                        HttpSession session,
//                        Model model) {
//
//        User user = authService.authenticate(email, password);
//
//        if (user != null) {
//          
//            session.setAttribute("loggedInUser", user);
//
//            
//            for (Role role : user.getRoles()) {
//                RoleType roleName = role.getName();
//
//                switch (roleName) {
//                    case ADMIN:
//                        return "redirect:/admin/dashboard";
//                    case STUDENT:
//                        return "redirect:/student/dashboard";
//                    case USER:
//                        return "redirect:/user/dashboard";
//                    default:
//                        break;
//                }
//            }
//
//            // If no matching role found
//            model.addAttribute("error", "Access denied. No valid role assigned.");
//            return "login";
//        } else {
//            model.addAttribute("error", "Invalid email or password");
//            return "login";
//        }
//    }




    


  
}
