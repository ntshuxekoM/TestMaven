package com.moconsulting.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.web.client.RestTemplate;

import com.moconsulting.constants.UserURIConstants;
import com.moconsulting.dao.CompanyDAO;
import com.moconsulting.dao.UserDAO;
import com.moconsulting.model.Company;
import com.moconsulting.model.Director;
import com.moconsulting.model.User;

public class CompanyControllerTest {

	public static final String SERVER_URI = "http://localhost:8080/moconsulting";
	
	public static void main(String args[]) {
		
		System.out.println("*****");
		testCreateCompany();
		System.out.println("*****");
		testGetAllCompanies();

	}

	private static void testCreateCompany() {
		
		CompanyDAO dao = new CompanyDAO();
		Company company = new Company();
		company.setCompanyName("NJ Matrix");
		company.setBusinessNature("IT");
		company.setBusinessStartDate("01-01-2017");
		company.setEnterpriseType("IT");
		company.setFinancialYearEnd("December");
		company.setRegistrationNumber("abcde");
		
		try {
			System.out.println(dao.createCompany(company));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void testGetAllCompanies() {
		CompanyDAO dao = new CompanyDAO();
		try {
			List<Company> allCompanies = dao.getAllComapnies();
			for(Company myCompany: allCompanies) {
				System.out.println("Company Name " + myCompany.getCompanyName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
