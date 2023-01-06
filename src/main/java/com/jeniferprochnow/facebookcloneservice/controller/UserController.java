package com.jeniferprochnow.facebookcloneservice.controller;

import com.jeniferprochnow.facebookcloneservice.entity.User;
import com.jeniferprochnow.facebookcloneservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody Map<String, String> requestParams) {
        String name = requestParams.get("name");
        String email = requestParams.get("email");
        String profilePic = requestParams.get("profilePic");

        User user = new User(
                name,
                email,
                profilePic,
                new HashSet<>()
        );

        user = userService.addUser(user);
        return user;
    }

    @GetMapping
    public List<User> getUsers(@RequestParam(required = false) String email) {
        if (email != null) {
            return userService.getUsersByEmail(email);
        }
        return userService.getUsers();
    }

}
