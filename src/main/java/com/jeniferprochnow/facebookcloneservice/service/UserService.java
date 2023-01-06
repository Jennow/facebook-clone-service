package com.jeniferprochnow.facebookcloneservice.service;

import com.jeniferprochnow.facebookcloneservice.entity.User;

import java.util.List;

public interface UserService {
    User addUser(User user);

    List<User> getUsers();

    List<User> getUsersByEmail(String email);
}
