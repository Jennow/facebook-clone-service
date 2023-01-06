package com.jeniferprochnow.facebookcloneservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import com.jeniferprochnow.facebookcloneservice.entity.Post;

@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name= "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String email;
    private String profilePic;

    @JsonIgnore
    @ManyToMany(mappedBy = "likes")
    private Set<Post> likedPosts;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<Comment> comments = new HashSet<>();

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public void addLikedPost(Post post) {
        likedPosts.add(post);
    }

    public User(String name, String email, String profilePic, Set<Post> likedPosts) {
        this.name = name;
        this.email = email;
        this.profilePic = profilePic;
        this.likedPosts = likedPosts;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public Set<Post> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(Set<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }
}
