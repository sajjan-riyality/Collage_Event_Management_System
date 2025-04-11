package com.rt.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.entity.Role;
import com.rt.entity.RoleType;
import com.rt.entity.User;
import com.rt.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> authenticate(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmailWithRoles(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) { // Plaintext password check
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    public String getRedirectUrlBasedOnRole(User user) {
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            RoleType roleType = role.getName();
            if (roleType == RoleType.ADMIN) {
                return "index";
            } else if (roleType == RoleType.STUDENT) {
                return "userDashbord";
            }
        }
        return "redirect:/user/dashboard";
    }

}
