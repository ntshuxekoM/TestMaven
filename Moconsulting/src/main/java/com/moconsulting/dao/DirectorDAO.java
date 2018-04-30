package com.moconsulting.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.moconsulting.helper.AbstractDAO;
import com.moconsulting.helper.AbstractDataProvider;
import com.moconsulting.helper.MySQLProvider;
import com.moconsulting.model.Director;

public class DirectorDAO extends AbstractDAO {

	private static final long serialVersionUID = -5109296593680166844L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createDirector(Director director) throws Exception {
		super.create(director);
		return "Director has been registered successfully";
	}

	public Director findDirectorById(Long id) throws Exception {
		String query = "select o from Director o where o.id =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("id", id);
		return (Director)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateDirector(Director director) throws Exception  {
		if((findDirectorById(director.getId())) != null) {
			super.update(director);
			return true;
		} else {
			throw new Exception("Error: Director Not found");
		}
	}
	
	public boolean removeDirector(Director director) throws Exception  {
		if((findDirectorById(director.getId())) != null) {
			super.delete(director);
			return true;
		} else {
			throw new Exception("Error: Company Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Director> getAllDirectors() throws Exception {
		return (List<Director>)super.getList("select o from Director o ");
	}
	
	@SuppressWarnings("unchecked")
	public List<Director> getAllDirectorsByComapnyId(Long company_id) throws Exception {
		String query = "select o from Director o where o.id =:company_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("company_id", company_id);
		return (List<Director>)super.getList(query, parameters);
	}
}
