package com.moconsulting.dao;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.moconsulting.helper.AbstractDAO;
import com.moconsulting.helper.AbstractDataProvider;
import com.moconsulting.helper.MySQLProvider;
import com.moconsulting.model.SalesInvoiceDetails;

public class SalesInvoiceDAO extends AbstractDAO {

	private static final long serialVersionUID = -5109296593680166844L;

	@Override
	public AbstractDataProvider getDataProvider() {
		return new MySQLProvider();
	}
	
	public String createInvoice(SalesInvoiceDetails salesQuationDetails) throws Exception {
		super.create(salesQuationDetails);
		return "Invoice Details has been added successfully";
	}

	public SalesInvoiceDetails findSalesInvoiceDetailsById(Long id) throws Exception {
		String query = "select o from SalesInvoiceDetails o where o.id =:id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("id", id);
		return (SalesInvoiceDetails)super.getUniqueResult(query, parameters);
	}
	
	public boolean updateSalesInvoiceDetails(SalesInvoiceDetails invoiceDetails) throws Exception  {
		if((findSalesInvoiceDetailsById(invoiceDetails.getId())) != null) {
			super.update(invoiceDetails);
			return true;
		} else {
			throw new Exception("Error: Quation Details Not found");
		}
	}
	
	public boolean removeSalesInvoiceDetails(SalesInvoiceDetails invoiceDetails) throws Exception  {
		if((findSalesInvoiceDetailsById(invoiceDetails.getId())) != null) {
			super.delete(invoiceDetails);
			return true;
		} else {
			throw new Exception("Error: Quation Details Not found");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<SalesInvoiceDetails> getAllSalesInvoiceDetails() throws Exception {
		return (List<SalesInvoiceDetails>)super.getList("select o from SalesInvoiceDetails o ");
	}
	
	@SuppressWarnings("unchecked")
	public List<SalesInvoiceDetails> getAllSalesInvoiceDetailsByCompanyId(Long company_id) throws Exception {
		String query = "select o from SalesInvoiceDetails o where o.id =:company_id";
		Map<String,Object>parameters = new Hashtable<String,Object>();
		parameters.put("company_id", company_id);
		return (List<SalesInvoiceDetails>)super.getList(query, parameters);
	}
}
