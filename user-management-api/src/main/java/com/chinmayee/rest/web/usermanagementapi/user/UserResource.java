package com.chinmayee.rest.web.usermanagementapi.user;
//package com.chinmayee.rest.web.usermanagementapi.user.UserNotFoundException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.el.stream.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.chinmayee.rest.web.usermanagementapi.post.Post;
import com.chinmayee.rest.web.usermanagementapi.post.PostRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/users") 
public class UserResource {
@Autowired
private PostRepository postRepository;

private UserRepository repository;
    
    public UserResource(UserRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping 
    public List<User> retrieveAllUsers() {
        return repository.findAll(); // JPA method
    }
    
    @GetMapping("/{id}")
    public User retrieveUser(@PathVariable int id) {
        Optional<User> user = repository.findById(id);
        if(user.isEmpty()) 
            throw new UserNotFoundException("id:"+id);
        return user.get();
    }
   
    
    @GetMapping("/{userId}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int userId) {
        User user = repository.findById(userId)
            .orElseThrow(() -> new UserNotFoundException("id-" + userId));
        return postRepository.findByUserId(userId);
    }
    
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = repository.save(user); // JPA saves + generates ID
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable int id, @Valid @RequestBody User user) {
        
        Optional<User> existingUser = repository.findById(id);
        
        if(existingUser.isEmpty()) {
            throw new UserNotFoundException("id:"+id);
        }
        
        user.setId(id); // Important: force ID from URL, not body
        repository.save(user); // JPA updates if ID exists
        
        return ResponseEntity.noContent().build(); // 204 No Content
    }
    @PostMapping("/{userId}/posts")
    public ResponseEntity<Object> createPostForUser(
            @PathVariable int userId, 
            @Valid @RequestBody Post post) {
        
        User user = repository.findById(userId)
                        .orElseThrow(() -> new UserNotFoundException("id-" + userId));
        
        post.setUser(user);
        Post savedPost = postRepository.save(post);
        
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();
        
        return ResponseEntity.created(location).build();
    }
  //  @PostMapping("/users/{id}/posts")
    public ResponseEntity<Object> createPost(@PathVariable int id, @Valid @RequestBody Post post) {
        User user = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found with id-" + id));
        
        post.setUser(user); // <-- CRITICAL: Set FK before save
        Post savedPost = postRepository.save(post);
        
        URI location = URI.create("/users/" + id + "/posts/" + savedPost.getId());
        return ResponseEntity.created(location).build(); // 201 Created
    }
		
}
