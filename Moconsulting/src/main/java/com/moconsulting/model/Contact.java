package com.moconsulting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.moconsulting.helper.IDataEntity;

@Entity
@Table(name="contact")
public class Contact implements IDataEntity {
	
	private static final long serialVersionUID = -5220518862515051558L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_contact_id", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
	
	@Column(name = "tell_number", nullable = false)
	private String tellNumber;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "fax", nullable = true)
	private String fax;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getTellNumber() {
		return tellNumber;
	}

	public void setTellNumber(String tellNumber) {
		this.tellNumber = tellNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", company=" + company + ", tellNumber=" + tellNumber + ", email=" + email
				+ ", fax=" + fax + "]";
	}
}
