package com.moconsulting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.moconsulting.helper.IDataEntity;

@Entity
@Table(name = "user")
public class User implements IDataEntity {

	private static final long serialVersionUID = -1253559783709554429L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "lastname", length = 100, nullable = false)
	private String lastname;

	@Column(name = "cell_no", length = 30, nullable = true)
	private String cellNO;
	
	@Column(name = "email", unique = true, length = 60, nullable = true)
	private String email;
	
	@Column(name = "password", length = 200, nullable = true)
	private String password;
	
	@Column(name = "role", length = 30, nullable = true)
	private String role;
	
	@Column(name = "date_created", nullable = true)
	private String date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getCellNO() {
		return cellNO;
	}

	public void setCellNO(String cellNO) {
		this.cellNO = cellNO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", cellNO=" + cellNO + ", email="
				+ email + ", password=" + password + ", role=" + role + ", date=" + date + "]";
	}

}
