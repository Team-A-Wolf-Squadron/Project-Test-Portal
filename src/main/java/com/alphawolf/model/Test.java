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
@Table(name="TESTS")
public class Test {

	@Column(name="TESTNAME")
	private String testName;
	

	@Id
	@GeneratedValue()
	@Column(name="TEST_ID")
	private Long id;

	
	@OneToMany(mappedBy="test", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<StudentTest> studentTests;
	@JsonIgnore
	public List<StudentTest> getStudentTests() {
		return studentTests;
	}
	@JsonIgnore
	public void setStudentTests(List<StudentTest> studentTests) {
		this.studentTests = studentTests;
	}
	@JsonIgnore
	public Provider getProvider() {
		return provider;
	}
	@JsonIgnore
	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	@ManyToOne
	private Provider provider;

	public Long getId() {
		return id;
	}

	public String getTestName() {
		return testName;
	}

	

	public void setId(Long id) {
		this.id = id;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}


}
