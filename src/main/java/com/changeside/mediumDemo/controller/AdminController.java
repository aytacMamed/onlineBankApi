package com.changeside.mediumDemo.controller;

import com.changeside.mediumDemo.model.User;
import com.changeside.mediumDemo.repository.UserRepository;
import com.changeside.mediumDemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.SqlReturnType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasAuthority('ADMIN')")
@RequiredArgsConstructor
public class AdminController {
   private final UserService userService;
    @GetMapping("/allUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/test")
    public String test(){
        return "SUCCESS";
    }
}

