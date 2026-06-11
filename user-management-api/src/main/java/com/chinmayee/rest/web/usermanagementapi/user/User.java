package com.chinmayee.rest.web.usermanagementapi.user;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chinmayee.rest.web.usermanagementapi.post.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "user_details")
public class User {
	protected User() {
		
	}
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnoreProperties("user") 
	private List<Post> posts = new ArrayList<>();
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message = "Name should have atleast 2 characters")
	//@JsonProperty("user_name")
	private String name;
	
	@Past(message = "Birth Date should be in the past")
	//@JsonProperty("birth_date")
	private LocalDate birthDate;
    
  //  protected User() {} // JPA needs no-arg constructor
    
    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
    
    // Getters + Setters for all fields - JPA needs this
    public Integer getId() { 
    	return id;
    	}
    public void setId(Integer id) { 
    	this.id = id; 
    	}
    public String getName() {
    	return name; 
    	}
    public void setName(String name) { 
    	this.name = name;
    	}
    public LocalDate getBirthDate() {
    	return birthDate; 
    	}
    public void setBirthDate(LocalDate birthDate) { 
    	this.birthDate = birthDate; 
    	}
    
}