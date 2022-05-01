package com.kcsitglobal.contact.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACT")
public class Contact {
	@Id
	@Column(name = "ID")
	private int id;

	@Column(name="NAME")
	private String name;

	@Column(name="MOBILENO")
	
	private String mobileno;
	
	
	@Column(name="EMAILID")
	private String emailId;
	
	@Column(name="CITY")
	private String city;

	public Contact() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", emailId=" + emailId + ", city="
				+ city + "]";
	}

}