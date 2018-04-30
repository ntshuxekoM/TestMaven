package com.moconsulting.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.web.client.RestTemplate;

import com.moconsulting.constants.UserURIConstants;
import com.moconsulting.dao.CompanyDAO;
import com.moconsulting.dao.DirectorDAO;
import com.moconsulting.dao.UserDAO;
import com.moconsulting.model.Company;
import com.moconsulting.model.Director;
import com.moconsulting.model.User;

public class DirectorControllerTest {

	public static final String SERVER_URI = "http://localhost:8080/moconsulting";
	
	public static void main(String args[]) {
		
		System.out.println("*****");
		testCreateDirector();
		System.out.println("*****");
		testGetAllDirectors();

	}

	private static void testCreateDirector() {
		
		DirectorDAO dao = new DirectorDAO();
		Company company = new Company();
		Director director = new Director();
		director.setDirectorName("Ntshuxeko");
		director.setDirectorIdNumber("940609570145");
		director.setDirectorSurname("Mabasa");
		director.setDirectorCellNumber("0124567896");
		director.setResidentialAddress("Ivory Park");
		company.setId(3L);
		director.setCompany(company);
		
		try {
			System.out.println(dao.createDirector(director));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void testGetAllDirectors() {
		DirectorDAO dao = new DirectorDAO();
		try {
			List<Director> allDirectors = dao.getAllDirectors();
			for(Director myDirector: allDirectors) {
				System.out.println("Director Name " + myDirector.getDirectorName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
