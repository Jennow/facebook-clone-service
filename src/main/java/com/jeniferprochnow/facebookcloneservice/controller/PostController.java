package com.jeniferprochnow.facebookcloneservice.controller;

import com.jeniferprochnow.facebookcloneservice.entity.Post;
import com.jeniferprochnow.facebookcloneservice.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/posts")
@CrossOrigin
public class PostController {
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post addPost(@RequestParam Map<String, String> requestParams) throws Exception {
        String strpost = requestParams.get("post");
        String userid = requestParams.get("userid");
        String file = requestParams.get("file");

        Post post = new Post(
                strpost,
                userid,
                file,
                new Date().getTime(),
                new HashSet<>()
        );

        post = postService.addPost(post, file);
        return post;
    }

    @GetMapping
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping("/{postId}/likes/{userId}")
    public Post addLikeToPost(@PathVariable String userId, @PathVariable String postId){
        return postService.addLikeToPost(postId, userId);
    }

    @PostMapping("/{postId}/comments/{userId}")
    public Post addCommentToPost(@PathVariable String userId, @PathVariable String postId, @RequestBody Map<String, String> requestParams){
        String comment = requestParams.get("comment");

        return postService.addCommentToPost(postId, userId, comment);
    }
}
