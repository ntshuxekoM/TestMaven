package com.moconsulting.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.moconsulting.helper.AbstractDAO;
import com.moconsulting.helper.AbstractDataProvider;
import com.moconsulting.helper.MySQLProvider;
import com.moconsulting.model.Company;

public class CompanyDAO extends AbstractDAO  {

	private static final long serialVersionUID = 8092554540965691077L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createCompany(Company company) throws Exception {
		super.create(company);
		return "Company has been registered successfully";
	}

	public Company findCompanyById(Long id)throws Exception {
		String query = "select o from Company o where o.id =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("id", id);
		return (Company)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateCompany(Company company) throws Exception  {
		if((findCompanyById(company.getId())) != null) {
			super.update(company);
			return true;
		} else {
			throw new Exception("Error: Company Not found");
		}
	}
	
	public boolean removeCompany(Company company) throws Exception  {
		if((findCompanyById(company.getId())) != null) {
			super.delete(company);
			return true;
		} else {
			throw new Exception("Error: Company Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Company> getAllComapnies() throws Exception {
		return (List<Company>)super.getList("select o from Company o ");
	}
}
