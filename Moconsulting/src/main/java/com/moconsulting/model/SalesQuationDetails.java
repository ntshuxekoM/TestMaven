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
@Table(name="SalesQuationDetails")
public class SalesQuationDetails implements IDataEntity {

	private static final long serialVersionUID = -8995805217493140586L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sales_quotation_id", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
	
	@Column(name = "sales_quotation_number", nullable = false)
	private String invoiceNumber;
	
	@Column(name = "qty", nullable = false)
	private int qty;
	
	@Column(name = "unit_price", nullable = true)
	private Double price;
	
	@Column(name = "discount", nullable = true)
	private Double discount;
	
	@Column(name = "total", nullable = true)
	private Double total;
	
	@Column(name = "description", nullable = false)
	private String description;

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

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "SalesQuationDetails [id=" + id + ", company=" + company + ", invoiceNumber=" + invoiceNumber + ", qty="
				+ qty + ", price=" + price + ", discount=" + discount + ", total=" + total + ", description="
				+ description + "]";
	}

}
