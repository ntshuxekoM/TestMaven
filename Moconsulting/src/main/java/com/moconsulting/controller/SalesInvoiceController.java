package com.moconsulting.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moconsulting.constants.InvoiceURIConstants;
import com.moconsulting.dao.SalesInvoiceDAO;
import com.moconsulting.model.SalesInvoiceDetails;

/**
 * Handles requests for the User service.
 */
@Controller
public class SalesInvoiceController {
	
	private SalesInvoiceDAO invoiceDAO = new SalesInvoiceDAO();
	
	@RequestMapping(value = InvoiceURIConstants.GET_ALL_INVOICES, method = RequestMethod.GET)
	public @ResponseBody List<SalesInvoiceDetails> getAllSalesInvoiceDetails() {
		List<SalesInvoiceDetails> allInvoices = new ArrayList<SalesInvoiceDetails>();
		try {
			allInvoices = invoiceDAO.getAllSalesInvoiceDetails();
			return allInvoices;
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allInvoices;
	}
	
	@RequestMapping(value = InvoiceURIConstants.CREATE_INVOICE, method = RequestMethod.POST)
	public @ResponseBody String createInvoice(@RequestBody SalesInvoiceDetails invoiceDetails) {
		try {
			return invoiceDAO.createInvoice(invoiceDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		}
	}
	
	@RequestMapping(value = InvoiceURIConstants.UPDATE_INVOICE, method = RequestMethod.PUT)
	public @ResponseBody boolean updateInvoice(@RequestBody SalesInvoiceDetails invoiceDetails) {
		try {
			return invoiceDAO.updateSalesInvoiceDetails(invoiceDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	@RequestMapping(value = InvoiceURIConstants.REMOVE_INVOICE, method = RequestMethod.DELETE)
	public @ResponseBody boolean removeInvoiceDAO(@RequestBody SalesInvoiceDetails invoiceDetails) {
		try {
			return invoiceDAO.removeSalesInvoiceDetails(invoiceDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@RequestMapping(value = InvoiceURIConstants.GET_ALL_INVOICES_BY_COMPANY_ID, method = RequestMethod.GET)
	public @ResponseBody List<SalesInvoiceDetails> getAllInvoicesByCompanyID(@PathVariable("companyId") Long company_id) {
		List<SalesInvoiceDetails> allInvoices = new ArrayList<SalesInvoiceDetails>();
		try {
			return invoiceDAO.getAllSalesInvoiceDetailsByCompanyId(company_id);
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		return allInvoices;
	}
	
}
