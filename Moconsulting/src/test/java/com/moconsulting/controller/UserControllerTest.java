package com.moconsulting.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.moconsulting.constants.UserURIConstants;
import com.moconsulting.dao.UserDAO;
import com.moconsulting.model.User;

public class UserControllerTest {

	public static final String SERVER_URI = "http://localhost:8080/moconsulting";
	
	public static void main(String args[]) {
		
		System.out.println("*****");
		testCreateUser();
		System.out.println("*****");
		testGetAllUsers();
		System.out.println("*****");
		testGetUser();

	}

	private static void testLogin() {
		RestTemplate restTemplate = new RestTemplate();
		//we can't get List<Employee> because JSON convertor doesn't know the type of
		//object in the list and hence convert it to default JSON object type LinkedHashMap
		Object object = restTemplate.getForObject(SERVER_URI+UserURIConstants.USER_LOGIN, Class.class);
	}
	
	private static void testCreateUser() {
		
		UserDAO dao = new UserDAO();
		User user = new User();
		user.setName("Ntshuxeko");
		user.setLastname("Mabasa");
		user.setEmail("nj@gmail.com");
		user.setCellNO("0788461928");
		user.setPassword("abcde");
		user.setDate("abcde");
		
		try {
			System.out.println(dao.addUser(user));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void testGetAllUsers() {
		UserDAO dao = new UserDAO();
		try {
			List<User> allUsers = dao.allUsers();
			for(User myuser: allUsers) {
				System.out.println("Name " + myuser.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void testGetUser() {
		UserDAO dao = new UserDAO();
		try {
			User user = dao.findUserById(1l);
			System.out.println("Name " + user.getName());
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
