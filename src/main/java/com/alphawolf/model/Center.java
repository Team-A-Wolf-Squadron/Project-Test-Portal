package com.alphawolf.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="CENTERS")
public class Center {
	
	@Id
	@GeneratedValue()
	@Column(name="cnt_id")
	private Long id;
	private String name;
	private String email;
	private String street;
	@Column(name="post_code")
	private String postCode;
	private String city;
	private String country;
	private String telephone;
	
	@OneToMany(mappedBy="center", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JsonIgnore
	private List<StudentTest> studentTests;
	@ManyToOne
	private User admin;
	public User getAdmin() {
		return admin;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public String getEmail() {
		return email;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPostCode() {
		return postCode;
	}
	public String getStreet() {
		return street;
	}
	@JsonIgnore
	public List<StudentTest> getStudentTests() {
		return studentTests;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setStudentTests(List<StudentTest> studentTests) {
		this.studentTests = studentTests;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	} 

}
