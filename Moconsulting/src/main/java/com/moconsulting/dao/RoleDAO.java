package com.moconsulting.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.moconsulting.helper.AbstractDAO;
import com.moconsulting.helper.AbstractDataProvider;
import com.moconsulting.helper.MySQLProvider;
import com.moconsulting.model.Roles;

public class RoleDAO extends AbstractDAO {

	private static final long serialVersionUID = 1L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createRole(Roles roles) throws Exception {
		super.create(roles);
		return "Role have been added successfully";
	}
	
	public Roles findRoleById(Long id) throws Exception {
		String query = "select o from Roles o where o.roleid =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("id", id);
		return (Roles)super.getUniqueResult(query, parameters);
	}
	
	public Roles findRoleByName(String role_name)throws Exception {
		String query = "select o from Roles o where o.rolename =:role_name";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("role_name", role_name);
		return (Roles)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateRole(Roles roles) throws Exception  {
		if((findRoleById(roles.getRoleid())) != null) {
			super.update(roles);
			return true;
		} else {
			throw new Exception("Error: Role Not found");
		}
	}
	
	public boolean removeRole(Roles roles) throws Exception  {
		if((findRoleById(roles.getRoleid())) != null) {
			super.delete(roles);
			return true;
		} else {
			throw new Exception("Error: Role Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Roles> allRoles() throws Exception {
		return (List<Roles>)super.getList("select o from Roles o ");
	}
}
