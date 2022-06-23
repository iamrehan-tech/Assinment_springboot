package com.relationoneToone.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.relationoneToone.model.User;
import com.relationoneToone.model.Userprofile;


@Service
public interface UserService {

	public List<User> getAllUser();
	public List<Userprofile>getAllUserprofile();
	
	
	public Optional<User> getUserById(long id);
	public Optional<Userprofile> getUserprofileById(long id);
	
	public List<User>putUser(User usr);
	public List<Userprofile>putUserprofile(Userprofile up);
	
	public void DeleteUser(long id);
	public void DeleteUserprofile(long id);
	
	public void createdataUserprofile(Userprofile u);
	public List<User> CreatedataUser(User u);
	

	
}
