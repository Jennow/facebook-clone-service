package com.jeniferprochnow.facebookcloneservice.repository;

import com.jeniferprochnow.facebookcloneservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    List<User> findByEmail(String email);
}
