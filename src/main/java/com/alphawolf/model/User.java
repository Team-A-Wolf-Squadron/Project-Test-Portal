package com.alphawolf.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="USERS")
public class User {
	private String address;
	private String postcode;
	@Column(name="personal_code_number")
	private String personalCodeNumber;
	private String sex;
	@Column(name="mail_address")
	private String mailAddress;
	private String company;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	
	@OneToMany(mappedBy="admin", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Center> center_admins;

	@Column(name="NP")
	String newPassword;
	@Column(name="PHONENBR")
	private String phonenumber;
	@NotNull
	private String username;
	private String password;
	@Column(name="AUTHORITY")
	private String role;
	private String enabled;

	@Id
	@GeneratedValue()
	@Column(name="ST_ID")
	private Long id;
	
	@OneToMany(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<StudentTest> studentTests;
	public String getAddress() {
		return address;
	}
	@JsonIgnore
	public List<Center> getCenter_admins() {
		return center_admins;
	}
	@JsonIgnore
	public List<Center> getCenterAdmins() {
		return center_admins;
	}

	public String getCompany() {
		return company;
	}

	public String getEnabled() {
		return enabled;
	}

	public String getFirstName() {
		return firstName;
	}

	public Long getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getPassword() {
		return password;
	}

	public String getPersonalCodeNumber() {
		return personalCodeNumber;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getRole() {
		return role;
	}
	public String getSex() {
		return sex;
	}
	@JsonIgnore
	public List<StudentTest> getStudentTests() {
		return studentTests;
	}

	public String getUsername() {
		return username;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCenter_admins(List<Center> center_admins) {
		this.center_admins = center_admins;
	}

	public void setCenterAdmin(List<Center> centers) {
		this.center_admins = centers;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPersonalCodeNumber(String personalCodeNumber) {
		this.personalCodeNumber = personalCodeNumber;
	}
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setStudentTest(List<StudentTest> studentTests) {
		this.studentTests = studentTests;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean addStudentTest(StudentTest studentTest) {
		return studentTests.add(studentTest);
	}
}
