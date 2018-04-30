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
@Table(name="director")
public class Director implements IDataEntity {

	private static final long serialVersionUID = -4274393966627597249L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "director_id", unique = true, nullable = false)
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
	
	@Column(name = "director_name", nullable = false)
	private String directorName;
	
	@Column(name = "director_surname", nullable = false)
	private String directorSurname;
	
	@Column(name = "director_id_number", nullable = true)
	private String directorIdNumber;
	
	@Column(name = "director_cell_number", nullable = true)
	private String directorCellNumber;
	
	@Column(name = "director_residential_address", nullable = true)
	private String residentialAddress;
	
	@Column(name = "status", nullable = true)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getDirectorSurname() {
		return directorSurname;
	}

	public void setDirectorSurname(String directorSurname) {
		this.directorSurname = directorSurname;
	}

	public String getDirectorIdNumber() {
		return directorIdNumber;
	}

	public void setDirectorIdNumber(String directorIdNumber) {
		this.directorIdNumber = directorIdNumber;
	}

	public String getDirectorCellNumber() {
		return directorCellNumber;
	}

	public void setDirectorCellNumber(String directorCellNumber) {
		this.directorCellNumber = directorCellNumber;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Director [id=" + id + ", company=" + company + ", directorName=" + directorName + ", directorSurname="
				+ directorSurname + ", directorIdNumber=" + directorIdNumber + ", directorCellNumber="
				+ directorCellNumber + ", residentialAddress=" + residentialAddress + ", status=" + status + "]";
	}
}
