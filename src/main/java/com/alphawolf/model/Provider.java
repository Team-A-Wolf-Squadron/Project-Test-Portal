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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PROVIDERS")
public class Provider {
	@Column(name="PROVIDER_NAME")
	private String providerName;
	@Id
	@GeneratedValue()
	private Long id;
	
	@OneToMany(mappedBy="provider", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Test> tests;
	
	public void setTests(List<Test> tests) {
		this.tests = tests;
	}
	@JsonIgnore
	public List<Test> getTests() {
		return tests;
	}
	public Long getId() {
		return id;
	}
	
	public String getProviderName() {
		return providerName;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

}