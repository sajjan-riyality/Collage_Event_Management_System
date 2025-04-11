package com.rt.controller;

import com.rt.entity.User;
import com.rt.service.EventService;
import com.rt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    

    @Autowired
    private EventService eventService;

   

    @PostMapping("/register")
    public String registerUser(
            @RequestParam("example-name") String username,
            @RequestParam("example-email") String email,
            @RequestParam("examplePassword") String password,
            Model model) {
    	System.out.println("registar user1 !");
        try {
            userService.registerUser(username, email, password);
            model.addAttribute("successMessage", "Registration successful. Please log in.");
            return "AuthPages/AuthLogin"; 
        } catch (Exception e) {
        	e.printStackTrace();
            model.addAttribute("errorMessage", e.getMessage());
            return "AuthPages/AuthRegister"; 
        }
    }





//
//    // Show Registration Form
//    @GetMapping("/availableEvents")
//    public String availableEvents(Model model) {
//    	model.addAttribute("events", eventService.getAllEvents()); 
//        return "User/availableEvents"; 
//    }
//    
    

//    // Handle Registration Submission
//    @PostMapping("/register")
//    public String registerUser(@ModelAttribute("user") User user) {
//        userService.registerUser(user);
//        return "redirect:/users/all";
//    }
//
//    // Show Add User Form
//    @GetMapping("/add")
//    public String showAddForm(Model model) {
//        model.addAttribute("user", new User());
//        return "user/add"; // JSP: /WEB-INF/views/user/add.jsp
//    }
//
//    // Handle Add Submission
//    @PostMapping("/add")
//    public String addUser(@ModelAttribute("user") User user) {
//        userService.saveUser(user);
//        return "redirect:/users/all";
//    }
//
//    // View All Users
//    @GetMapping("/all")
//    public String getAllUsers(Model model) {
//        List<User> users = userService.getAllUsers();
//        model.addAttribute("users", users);
//        return "user/list"; // JSP: /WEB-INF/views/user/list.jsp
//    }
//
//    // View User Details
//    @GetMapping("/view/{id}")
//    public String viewUser(@PathVariable("id") Long id, Model model) {
//        User user = userService.getUserById(id).orElse(null);
//        if (user == null) {
//            model.addAttribute("error", "User not found!");
//            return "redirect:/users/all";
//        }
//        model.addAttribute("user", user);
//        return "user/view"; // JSP: /WEB-INF/views/user/view.jsp
//    }
//
//    // Show Edit Form
//    @GetMapping("/update/{id}")
//    public String showEditForm(@PathVariable("id") Long id, Model model) {
//        User user = userService.getUserById(id).orElse(null);
//        if (user == null) {
//            return "redirect:/users/all";
//        }
//        model.addAttribute("user", user);
//        return "user/edit"; // JSP: /WEB-INF/views/user/edit.jsp
//    }
//
//    // Handle Edit Submission
//    @PostMapping("/update/{id}")
//    public String updateUser(@PathVariable("id") Long id, @ModelAttribute("user") User user) {
//        userService.updateUser(id, user);
//        return "redirect:/users/all";
//    }
    
    

//    // Delete User
//    @GetMapping("/delete/{id}")
//    public String deleteUser(@RequestParam("id") Long id) {
//        userService.deleteUser(id);
//        return "redirect:/users/all";
//    }
}
