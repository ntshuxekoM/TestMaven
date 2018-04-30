package com.moconsulting.controller;

import com.moconsulting.dao.RoleDAO;
import com.moconsulting.model.Roles;


public class RoleControllerTest {

	public static final String SERVER_URI = "http://localhost:8080/moconsulting";
	
	public static void main(String args[]) {
		System.out.println("*****");
		testGetRole();

	}
	private static void testGetRole() {
		RoleDAO dao = new RoleDAO();
		try {
			Roles role = dao.findRoleById(3L);
			System.out.println(role.toString());
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
