package com.neoteric.demoui.controller;
import com.neoteric.demoui.model.User;
import com.neoteric.demoui.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User registerUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
