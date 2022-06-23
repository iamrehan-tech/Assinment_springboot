package com.relationoneToone.implement;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.relationoneToone.Repo.UserRepo;
import com.relationoneToone.Repo.UserprofileRepo;
import com.relationoneToone.model.User;
import com.relationoneToone.model.Userprofile;
import com.relationoneToone.services.UserService;

@Component
public class Userimplement implements UserService {

	String email_regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	@Autowired
	UserRepo userrepo;

	@Autowired
	UserprofileRepo userprofilerepo;

	@Override
	public List<User> getAllUser() {
		System.out.println("Find It...");
		return userrepo.findAll();
	}

	@Override
	public List<Userprofile> getAllUserprofile() {
		System.out.println("User_profile section going on...");
		return userprofilerepo.findAll();
	}

	@Override
	public Optional<User> getUserById(long id) {
		return userrepo.findById(id);
	}

	@Override
	public Optional<Userprofile> getUserprofileById(long id) {

		return userprofilerepo.findById(id);
	}

	@Override
	public List<User> putUser(User usr) {

		userrepo.save(usr);
		return userrepo.findAll();
	}

	@Override
	public List<Userprofile> putUserprofile(Userprofile up) {

		return userprofilerepo.findAll();
	}

	@Override
	public void DeleteUser(long id) {
		userrepo.deleteById(id);
		System.out.println("Delete successfull....");
	}

	@Override
	public void DeleteUserprofile(long id) {
		userprofilerepo.deleteById(id);
		System.out.println("Delete data from userprofile block...");

	}

	@Override
	public void createdataUserprofile(Userprofile u) {
		userprofilerepo.save(u);
		System.out.println("Successfull create the data userprofile block...");
	}

	
	@Override
	public List<User> CreatedataUser(User u) {
		try {
			Pattern pattern = Pattern.compile(email_regex);
			java.util.regex.Matcher matcher = pattern.matcher(u.getEmail());
			if (matcher.matches() == true) {
				if (isValidPassword(u.getPassword()) == true) {
					userrepo.save(u);
				} else {
					System.out.println("length of password should be atleast 10 with a special character!");
				}
			} else {
				System.out.println("email is not valid!");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("invalid email or password format is not valid!");
		}
		return userrepo.findAll();
	}

	private boolean isValidPassword(String password) {
		String regex_pass = "^(?=.*[@#$%^&+=])" + "(?=\\S+$).{10,120}$";
		Pattern p = Pattern.compile(regex_pass);
		if (password == null) {
			return false;
		}
		Matcher m = p.matcher(password);
		return m.matches();
	}

}
