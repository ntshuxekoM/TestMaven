package com.moconsulting.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.moconsulting.helper.IDataEntity;

@Entity
@Table(name="company")
public class Company implements IDataEntity {

	private static final long serialVersionUID = -3437213505204650224L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "company_name", nullable = false)
	private String companyName;
	
	@Column(name = "registration_number", nullable = false)
	private String registrationNumber;
	
	@Column(name = "business_start_date", nullable = true)
	private String businessStartDate;
	
	@Column(name = "enterprise_type", nullable = true)
	private String enterpriseType;
	
	@Column(name = "financial_year_end", nullable = true)
	private String financialYearEnd;
	
	@Column(name = "postal_address", nullable = true)
	private String postalAddress;
	
	@Column(name = "trading_name", nullable = true)
	private String tradingName;
	
	@Column(name = "business_nature", nullable = true)
	private String businessNature;
	
	@OneToMany(mappedBy = "company")
	private Set<Director> directors;
	
	@OneToMany(mappedBy = "company")
	private Set<Contact> contacts;
	
	@OneToMany(mappedBy = "company")
	private Set<SalesInvoiceDetails> invoiceDetails;  

	@OneToMany(mappedBy = "company")
	private Set<SalesQuationDetails> quationDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getBusinessStartDate() {
		return businessStartDate;
	}

	public void setBusinessStartDate(String businessStartDate) {
		this.businessStartDate = businessStartDate;
	}

	public String getEnterpriseType() {
		return enterpriseType;
	}

	public void setEnterpriseType(String enterpriseType) {
		this.enterpriseType = enterpriseType;
	}

	public String getFinancialYearEnd() {
		return financialYearEnd;
	}

	public void setFinancialYearEnd(String financialYearEnd) {
		this.financialYearEnd = financialYearEnd;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	public String getBusinessNature() {
		return businessNature;
	}

	public void setBusinessNature(String businessNature) {
		this.businessNature = businessNature;
	}

	public Set<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(Set<Director> directors) {
		this.directors = directors;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Set<SalesInvoiceDetails> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(Set<SalesInvoiceDetails> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public Set<SalesQuationDetails> getQuationDetails() {
		return quationDetails;
	}

	public void setQuationDetails(Set<SalesQuationDetails> quationDetails) {
		this.quationDetails = quationDetails;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", registrationNumber=" + registrationNumber
				+ ", businessStartDate=" + businessStartDate + ", enterpriseType=" + enterpriseType
				+ ", financialYearEnd=" + financialYearEnd + ", postalAddress=" + postalAddress + ", tradingName="
				+ tradingName + ", businessNature=" + businessNature + ", directors=" + directors + ", contacts="
				+ contacts + ", invoiceDetails=" + invoiceDetails + ", quationDetails=" + quationDetails + "]";
	} 
	
}
