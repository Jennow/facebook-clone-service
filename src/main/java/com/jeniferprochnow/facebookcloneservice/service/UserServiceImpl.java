package com.jeniferprochnow.facebookcloneservice.service;

import com.jeniferprochnow.facebookcloneservice.entity.User;
import com.jeniferprochnow.facebookcloneservice.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        User userEntity = new User();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return userEntity;
    }

    @Override
    public List<User> getUsers() {
        List<User> userEntities = userRepository.findAll();
        return userEntities;
    }

    @Override
    public List<User> getUsersByEmail(String email) {
        List<User> userEntities = userRepository.findByEmail(email);
        return userEntities;
    }
}
