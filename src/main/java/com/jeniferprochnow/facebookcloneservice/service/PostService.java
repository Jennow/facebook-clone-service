package com.jeniferprochnow.facebookcloneservice.service;

import com.jeniferprochnow.facebookcloneservice.entity.Post;

import java.util.List;
import java.util.Map;

public interface PostService {
    Post addPost(Post post, String file) throws Exception;

    List<Post> getPosts();

    Post addLikeToPost(String postId, String userId);

    Post addCommentToPost(String postId, String userId, String comment);
}
