package com.moconsulting.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moconsulting.constants.RolesURIConstants;
import com.moconsulting.dao.RoleDAO;
import com.moconsulting.model.Roles;

/**
 * Handles requests for the Role service.
 */
@Controller
public class RoleController {
	
	private RoleDAO roleDAO = new RoleDAO();
	
	@RequestMapping(value = RolesURIConstants.GET_ALL_ROLES, method = RequestMethod.GET)
	public @ResponseBody List<Roles> getAllRoles() {
		List<Roles> allRoles = new ArrayList<Roles>();
		try {
			allRoles = roleDAO.allRoles();
			return allRoles;
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allRoles;
	}
	
	@RequestMapping(value = RolesURIConstants.CREATE_ROLE, method = RequestMethod.POST)
	public @ResponseBody String createRole(@RequestBody Roles role) {
		try {
			return roleDAO.createRole(role);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = RolesURIConstants.UPDATE_ROLE, method = RequestMethod.PUT)
	public @ResponseBody boolean updateRole(@RequestBody Roles role) {
		try {
			return roleDAO.updateRole(role);
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	
	@RequestMapping(value = RolesURIConstants.REMOVE_ROLE, method = RequestMethod.DELETE)
	public @ResponseBody boolean removeRole(@RequestBody Roles role) {
		try {
			return roleDAO.removeRole(role);
		} catch (Exception e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
	}
	
}
