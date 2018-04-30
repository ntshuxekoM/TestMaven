package com.moconsulting.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moconsulting.constants.DirectorURIConstants;
import com.moconsulting.dao.DirectorDAO;
import com.moconsulting.model.Director;

/**
 * Handles requests for the User service.
 */
@Controller
public class DirectorController {
	
	private DirectorDAO directorDAO = new DirectorDAO();
	
	@RequestMapping(value = DirectorURIConstants.GET_ALL_DIRECTORS, method = RequestMethod.GET)
	public @ResponseBody List<Director> getAllDirectors() {
		List<Director> allDirectors = new ArrayList<Director>();
		try {
			allDirectors = directorDAO.getAllDirectors();
			return allDirectors;
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allDirectors;
	}
	
	@RequestMapping(value = DirectorURIConstants.CREATE_DIRECTOR, method = RequestMethod.POST)
	public @ResponseBody String createDirector(@RequestBody Director director) {
		try {
			return directorDAO.createDirector(director);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = DirectorURIConstants.UPDATE_DIRECTOR, method = RequestMethod.PUT)
	public @ResponseBody boolean updateDirector(@RequestBody Director director) {
		try {
			return directorDAO.updateDirector(director);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@RequestMapping(value = DirectorURIConstants.REMOVE_DIRECTOR, method = RequestMethod.DELETE)
	public @ResponseBody boolean removeDirector(@RequestBody Director director) {
		try {
			return directorDAO.removeDirector(director);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = DirectorURIConstants.GET_ALL_DIRECTORS_BY_COMPANY_ID, method = RequestMethod.GET)
	public @ResponseBody List<Director> getAllDirectorsByCompanyID(@PathVariable("companyId") Long company_id) {
		List<Director> allDirectors = new ArrayList<Director>();
		try {
			allDirectors = directorDAO.getAllDirectorsByComapnyId(company_id);
			return allDirectors;
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allDirectors;
	}
	
}
