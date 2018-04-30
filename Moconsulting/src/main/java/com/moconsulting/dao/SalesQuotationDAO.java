package com.moconsulting.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.moconsulting.helper.AbstractDAO;
import com.moconsulting.helper.AbstractDataProvider;
import com.moconsulting.helper.MySQLProvider;
import com.moconsulting.model.SalesQuationDetails;

public class SalesQuotationDAO extends AbstractDAO {

	private static final long serialVersionUID = -5109296593680166844L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createQuotation(SalesQuationDetails salesQuationDetails) throws Exception {
		super.create(salesQuationDetails);
		return "Quation Details has been added successfully";
	}

	public SalesQuationDetails findSalesQuationDetailsById(Long id) throws Exception {
		String query = "select o from SalesQuationDetails o where o.id =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("id", id);
		return (SalesQuationDetails)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateSalesQuationDetails(SalesQuationDetails quationDetails) throws Exception  {
		if((findSalesQuationDetailsById(quationDetails.getId())) != null) {
			super.update(quationDetails);
			return true;
		} else {
			throw new Exception("Error: Quation Details Not found");
		}
	}
	
	public boolean removeSalesQuationDetails(SalesQuationDetails quationDetails) throws Exception  {
		if((findSalesQuationDetailsById(quationDetails.getId())) != null) {
			super.delete(quationDetails);
			return true;
		} else {
			throw new Exception("Error: Quation Details Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SalesQuationDetails> getAllSalesQuationDetails() throws Exception {
		return (List<SalesQuationDetails>)super.getList("select o from SalesQuationDetails o ");
	}
	
	@SuppressWarnings("unchecked")
	public List<SalesQuationDetails> getAllSalesQuationDetailsByComapnyId(Long company_id) throws Exception {
		String query = "select o from SalesQuationDetails o where o.id =:company_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("company_id", company_id);
		return (List<SalesQuationDetails>)super.getList(query, parameters);
	}
}
