package com.chinmayee.rest.web.usermanagementapi.post;

import com.chinmayee.rest.web.usermanagementapi.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Size(min=10, message="Description must be at least 10 chars")
    private String description;
    
   @ManyToOne
    @JoinColumn(name = "user_id")
   @JsonIgnoreProperties("posts")
    private User user;
    
    public Post() {}
    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }
    
    // Generate getters/setters: Source → Generate Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
