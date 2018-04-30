package com.moconsulting.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.jasypt.util.password.StrongPasswordEncryptor;

import com.moconsulting.constants.UserURIConstants;
import com.moconsulting.dao.UserDAO;
import com.moconsulting.model.User;

/**
 * Handles requests for the User service.
 */
@Controller
public class UserController {
	
	private UserDAO userDAO = new UserDAO();
	private StrongPasswordEncryptor strongPasswordEncryptor = new StrongPasswordEncryptor();

	@RequestMapping(value = UserURIConstants.USER_LOGIN, method = RequestMethod.GET)
	public @ResponseBody User Login(@PathVariable("username") String username, @PathVariable("password") String password) {
		try {
			User user = userDAO.findUserByEmail(username);
			if(isPasswordCorrect(password, user)) {
				return user;
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return new User();
		
	}
	
	@RequestMapping(value = UserURIConstants.GET_ALL_USERS, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<User>();
		try {
			allUsers = userDAO.allUsers();
			return allUsers;
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allUsers;
	}
	
	@RequestMapping(value = UserURIConstants.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody String createUser(@RequestBody User user) {
		try {
			user.setPassword(strongPasswordEncryptor.encryptPassword(user.getPassword()));
			return userDAO.addUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	private boolean isPasswordCorrect(String plainPassword, User user) {
		if (strongPasswordEncryptor.checkPassword(plainPassword, user.getPassword())) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
}
