package com.relationoneToone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relationoneToone.Repo.UserRepo;
import com.relationoneToone.model.User;
import com.relationoneToone.model.Userprofile;
import com.relationoneToone.services.UserService;


@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	 UserService userservice;
	
	@Autowired
	UserRepo userrepo;
	
	
	@GetMapping("/")
	public List<User> getAllUser() {
		return userservice.getAllUser();
	}
	
	@GetMapping("/{id}")
	  public User getUserById(@PathVariable("id") long id)
	  {
		 User U=userrepo.findById(id).get();  
		return U;
	  }
	
	@PutMapping("/")
	 public void putUser(@RequestBody User usr)
	  {
		userrepo.save(usr);
		
	  }
	
	@DeleteMapping("/{id}")
	public void DeleteUser(@PathVariable("id") long id) {
		userrepo.deleteById(id);
	}
	
	@PostMapping("/")
	public void createdataUser(@RequestBody User u) {
		userrepo.save(u);
		System.out.println("Creare the user data successfull....");
	}
	 
	
}
