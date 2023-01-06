package com.jeniferprochnow.facebookcloneservice.repository;

import com.jeniferprochnow.facebookcloneservice.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String > {
}
