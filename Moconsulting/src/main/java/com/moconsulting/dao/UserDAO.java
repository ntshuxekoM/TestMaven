package com.moconsulting.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.moconsulting.model.User;
import com.moconsulting.helper.AbstractDAO;
import com.moconsulting.helper.AbstractDataProvider;
import com.moconsulting.helper.MySQLProvider;

public class UserDAO extends AbstractDAO {

	private static final long serialVersionUID = 1L;

	@Override
	public AbstractDataProvider getDataProvider() {
		
		return new MySQLProvider();
	}
	
	public String addUser(User user) throws Exception {
		if (findUserByEmail(user.getEmail()) == null) {
			super.create(user);
			return "User has been registered successfully";
		} else {
			throw new Exception("User with same email already exist");
		}
	}

	public User findUserById(Long id)throws Exception {
		String query = "select o from User o where o.id =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("id", id);
		return (User)super.getUniqueResult(query, parameters);
	}
	
	public User findUserByEmail(String email)throws Exception {
		String query = "select o from User o where o.email =:email";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("email", email);
		return (User)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateUser(User user) throws Exception  {
		if((findUserById(user.getId())) != null) {
			super.update(user);
			return true;
		} else {
			throw new Exception("Error: User Not found");
		}
	}
	
	public boolean removeUser(User user) throws Exception  {
		if((findUserById(user.getId())) != null) {
			super.delete(user);
			return true;
		} else {
			throw new Exception("Error: User Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<User> allUsers() throws Exception {
		return (List<User>)super.getList("select o from User o ");
	}
	
}
