package com.moconsulting.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.moconsulting.helper.AbstractDAO;
import com.moconsulting.helper.AbstractDataProvider;
import com.moconsulting.helper.MySQLProvider;
import com.moconsulting.model.Contact;

public class ContactDAO extends AbstractDAO {

	private static final long serialVersionUID = -4488515122156815696L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createContact(Contact contact) throws Exception {
		super.create(contact);
		return "Contact has been added successfully";
	}

	public Contact findContactById(Long id) throws Exception {
		String query = "select o from Contact o where o.id =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("id", id);
		return (Contact)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateContact(Contact contact) throws Exception  {
		if((findContactById(contact.getId())) != null) {
			super.update(contact);
			return true;
		} else {
			throw new Exception("Error: Contact Not found");
		}
	}
	
	public boolean removeContact(Contact contact) throws Exception  {
		if((findContactById(contact.getId())) != null) {
			super.delete(contact);
			return true;
		} else {
			throw new Exception("Error: Contact Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> getAllContacts() throws Exception {
		return (List<Contact>)super.getList("select o from Contact o ");
	}
	
	@SuppressWarnings("unchecked")
	public List<Contact> getAllContactsByComapnyId(Long company_id) throws Exception {
		String query = "select o from Contact o where o.id =:company_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("company_id", company_id);
		return (List<Contact>)super.getList(query, parameters);
	}
}
