package com.moconsulting.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moconsulting.constants.QuotationURIConstants;
import com.moconsulting.dao.SalesQuotationDAO;
import com.moconsulting.model.SalesQuationDetails;

/**
 * Handles requests for the User service.
 */
@Controller
public class SalesQuotationController {
	
	private SalesQuotationDAO quotationDAO = new SalesQuotationDAO();
	
	@RequestMapping(value = QuotationURIConstants.GET_ALL_QUOTATIONS, method = RequestMethod.GET)
	public @ResponseBody List<SalesQuationDetails> getAllQuotations() {
		List<SalesQuationDetails> allQuotation = new ArrayList<SalesQuationDetails>();
		try {
			return quotationDAO.getAllSalesQuationDetails();
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allQuotation;
	}
	
	@RequestMapping(value = QuotationURIConstants.CREATE_QUOTATION, method = RequestMethod.POST)
	public @ResponseBody String createQuotation(@RequestBody SalesQuationDetails quationDetails) {
		try {
			return quotationDAO.createQuotation(quationDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = QuotationURIConstants.UPDATE_QUOTATION, method = RequestMethod.PUT)
	public @ResponseBody boolean updateInvoice(@RequestBody SalesQuationDetails quationDetails) {
		try {
			return quotationDAO.updateSalesQuationDetails(quationDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@RequestMapping(value = QuotationURIConstants.REMOVE_QUOTATION, method = RequestMethod.DELETE)
	public @ResponseBody boolean removeInvoiceDAO(@RequestBody SalesQuationDetails quationDetails) {
		try {
			return quotationDAO.removeSalesQuationDetails(quationDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = QuotationURIConstants.GET_ALL_QUOTATIONS_BY_COMPANY_ID, method = RequestMethod.GET)
	public @ResponseBody List<SalesQuationDetails> getAllInvoicesByCompanyID(@PathVariable("companyId") Long company_id) {
		List<SalesQuationDetails> allIQuotations = new ArrayList<SalesQuationDetails>();
		try {
			return quotationDAO.getAllSalesQuationDetailsByComapnyId(company_id);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allIQuotations;
	}
	
}
