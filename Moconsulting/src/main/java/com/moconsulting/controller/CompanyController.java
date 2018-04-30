package com.moconsulting.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moconsulting.constants.CompanyURIConstants;
import com.moconsulting.dao.CompanyDAO;
import com.moconsulting.model.Company;

/**
 * Handles requests for the User service.
 */
@Controller
public class CompanyController {
	
	private CompanyDAO companyDAO = new CompanyDAO();
	
	@RequestMapping(value = CompanyURIConstants.GET_ALL_COMPANIES, method = RequestMethod.GET)
	public @ResponseBody List<Company> getAllCompanies() {
		List<Company> allCompanies = new ArrayList<Company>();
		try {
			allCompanies = companyDAO.getAllComapnies();
			return allCompanies;
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allCompanies;
	}
	
	@RequestMapping(value = CompanyURIConstants.CREATE_COMPANY, method = RequestMethod.POST)
	public @ResponseBody String createComapny(@RequestBody Company company) {
		try {
			return companyDAO.createCompany(company);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = CompanyURIConstants.REMOVE_COMPANY, method = RequestMethod.DELETE)
	public @ResponseBody Boolean removeCompany(@RequestBody Company company) {
		try {
			return companyDAO.removeCompany(company);
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	
	@RequestMapping(value = CompanyURIConstants.UPDATE_COMPANY, method = RequestMethod.PUT)
	public @ResponseBody Boolean removeComapny(@RequestBody Company company) {
		try {
			return companyDAO.updateCompany(company);
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
}
