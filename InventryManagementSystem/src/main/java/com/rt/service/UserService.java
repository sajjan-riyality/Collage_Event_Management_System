package com.rt.service;

import com.rt.entity.User;
import com.rt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user) {
        Optional<User> existing = userRepository.findByEmail(user.getEmail());
        if (existing.isPresent()) {
            throw new RuntimeException("Email already registered!");
        }
        user.setRoles(new HashSet<>());
        userRepository.save(user);
    }
    


    public User registerUser(String username, String email, String password) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new RuntimeException("Email is already registered.");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password); // You can use BCryptPasswordEncoder here
        user.setRoles(new HashSet<>()); // Empty role set by default

        return userRepository.save(user);
    }
    
    

    public User saveUser(User user) {
    	 Optional<User> existing = userRepository.findByEmail(user.getEmail());
         if (existing.isPresent()) {
        	 throw new RuntimeException("Email already registered!");
        	 }
      
     
		return  userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public boolean updateUser(Long id, User user) {
        Optional<User> existing = userRepository.findById(id);
        if (existing.isPresent()) {
            User updated = existing.get();
            updated.setUsername(user.getUsername());
            updated.setEmail(user.getEmail());
            updated.setPassword(user.getPassword());
            updated.setRoles(user.getRoles());
            userRepository.save(updated);
            return true;
        }
        return false;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

//    public User authenticate(String email, String password) {
//        Optional<User> user = userRepository.findByEmail(email);
//        if (user != null && user.getPassword().equals(password)) {
//            return user;
//        }
//        return null;
//    }


	
}
