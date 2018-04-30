package com.moconsulting.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moconsulting.constants.ContactURIConstants;
import com.moconsulting.dao.ContactDAO;
import com.moconsulting.model.Contact;

/**
 * Handles requests for the User service.
 */
@Controller
public class ContactController {
	
	private ContactDAO contactDAO = new ContactDAO();
	
	@RequestMapping(value = ContactURIConstants.GET_ALL_CONTACTS, method = RequestMethod.GET)
	public @ResponseBody List<Contact> getAllContatcs() {
		List<Contact> allContacts = new ArrayList<Contact>();
		try {
			allContacts = contactDAO.getAllContacts();
			return allContacts;
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allContacts;
	}
	
	@RequestMapping(value = ContactURIConstants.CREATE_CONTACT, method = RequestMethod.POST)
	public @ResponseBody String createContact(@RequestBody Contact contact) {
		try {
			return contactDAO.createContact(contact);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = ContactURIConstants.UPDATE_CONTACT, method = RequestMethod.PUT)
	public @ResponseBody boolean updateContact(@RequestBody Contact contact) {
		try {
			return contactDAO.updateContact(contact);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@RequestMapping(value = ContactURIConstants.REMOVE_CONTACT, method = RequestMethod.DELETE)
	public @ResponseBody boolean removeContact(@RequestBody Contact contact) {
		try {
			return contactDAO.removeContact(contact);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = ContactURIConstants.GET_ALL_CONTACT_BY_COMPANY_ID, method = RequestMethod.GET)
	public @ResponseBody List<Contact> getAllContactsByCompanyID(@PathVariable("companyId") Long company_id) {
		List<Contact> allContacts = new ArrayList<Contact>();
		try {
			allContacts = contactDAO.getAllContactsByComapnyId(company_id);
			return allContacts;
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allContacts;
	}
	
}
