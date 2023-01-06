package com.jeniferprochnow.facebookcloneservice.service;

import com.jeniferprochnow.facebookcloneservice.entity.Comment;
import com.jeniferprochnow.facebookcloneservice.entity.Post;
import com.jeniferprochnow.facebookcloneservice.entity.User;
import com.jeniferprochnow.facebookcloneservice.repository.CommentRepository;
import com.jeniferprochnow.facebookcloneservice.repository.PostRepository;
import com.jeniferprochnow.facebookcloneservice.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.beans.Encoder;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
   @Autowired
    private PostRepository postRepository;
   @Autowired
    private UserRepository userRepository;
   @Autowired
   private CommentRepository commentRepository;

    public PostServiceImpl(PostRepository postRepository,
                           UserRepository userRepository,
                           CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    @Override
    public Post addPost(Post post, String file) throws Exception {
        try {
            Post postEntity = new Post();
            BeanUtils.copyProperties(post, postEntity);

            if (file != null && !file.equalsIgnoreCase("null")) {
                postEntity.setImage(file);
            } else {
                postEntity.setImage(null);
            }
            postEntity = postRepository.save(postEntity);
            post.setId(postEntity.getId());
            post.setImage(postEntity.getImage());
        } catch (Exception e) {
            throw new Exception("Could not save Post: " + e);
        }
        return post;
    }

    @Override
    public List<Post> getPosts() {
        List<Post> postEntities = postRepository.findAll(Sort.by(Sort.Direction.DESC, "timestamp"));

        return postEntities;
    }

    @Override
    public Post addLikeToPost(String postId, String userId) {
        Post post = postRepository.findById(postId).get();
        User user = userRepository.findById(userId).get();
        post.addLike(user);
        return postRepository.save(post);
    }

    @Override
    public Post addCommentToPost(String postId, String userId, String comment) {
        Post post = postRepository.findById(postId).get();
        User user = userRepository.findById(userId).get();

        Comment commentObject = new Comment(
                comment,
                user,
                post,
                new Date().getTime()
        );


        commentRepository.save(commentObject);
        return post;
    }
}
