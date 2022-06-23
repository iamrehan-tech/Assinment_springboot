package com.relationoneToone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relationoneToone.Repo.UserRepo;
import com.relationoneToone.Repo.UserprofileRepo;
import com.relationoneToone.model.User;
import com.relationoneToone.model.Userprofile;
import com.relationoneToone.services.UserService;

@RestController
@RequestMapping("profile")
public class UserprofileController {
	@Autowired
	UserService userservice;

	@Autowired
	UserprofileRepo userprofilerepo;

	@GetMapping("/")
	public List<Userprofile> getAllUserprofile() {
		return userservice.getAllUserprofile();
	}

	@GetMapping("/{id}")
	public Userprofile getUserprofileById(@PathVariable("id") long id) {
		Userprofile U1 = userprofilerepo.findById(id).get();
		return U1;
	}

	@PutMapping("/")
	public void putUserprofile(@RequestBody Userprofile up) {
		userprofilerepo.save(up);
		System.out.println("Update data successfull in userprofile block...");
	}

	@DeleteMapping("/{id}")
	public void DeleteUserprofile(@PathVariable("id") long id) {
		userprofilerepo.deleteById(id);
	}

	@PostMapping("/")
	public void createdataUserprofile(@RequestBody Userprofile u) {
		userprofilerepo.save(u);
	}
}
