package com.rt.controller;

import com.rt.entity.Registration;
import com.rt.entity.User;
import com.rt.repository.UserRepository;
import com.rt.service.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserRegistrationController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    RegistrationService registrationService ;

    @GetMapping("/registration")
    public String getAllRegistrations(Model model) {
        List<Registration> registrations = registrationService.getAllRegistrations();
        model.addAttribute("registrations", registrations);
        return "registration-list"; 
    }


    // ✅ Get Single User by ID (GET)
    @GetMapping("/{id}")
    public User getUserById(@RequestParam Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

   
    @PostMapping("/add")
    public User createUser(@ModelAttribute User user) {
        return userRepository.save(user);
    }

    // ✅ Update User (PUT)
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
//        User existingUser = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
//
//        existingUser.setUsername(updatedUser.getUsername());
//        existingUser.setEmail(updatedUser.getEmail());
//        existingUser.setPassword(updatedUser.getPassword());
//        existingUser.setRoles(updatedUser.getRoles());
//        existingUser.setIsLoggedIn(((Object) updatedUser).getIsLoggedIn());
//        existingUser.setLastLogin(updatedUser.getLastLogin());
//        existingUser.setSessionToken(updatedUser.getSessionToken());
//
//        return userRepository.save(existingUser);
//    }

//    // ✅ Delete User (DELETE)
//    @DeleteMapping("/{id}")
//    public String deletefegisterdUser(@PathVariable Long id) {
//        userRepository.deleteById(id);
//        return "User deleted with ID: " + id;
//    }
}
