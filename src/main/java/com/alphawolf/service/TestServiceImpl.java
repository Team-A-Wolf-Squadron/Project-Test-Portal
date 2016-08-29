package com.alphawolf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alphawolf.model.Test;
import com.alphawolf.repository.TestRepository;

@Service("testService")
public class TestServiceImpl implements TestService {

	@Autowired
	private TestRepository testRepository;
	
	@Transactional
	public Test save(Test test) {
		return testRepository.save(test);
	}

	public List<Test> findAllTest() {
		return testRepository.findAll();
	}

	public Test findById(Long id) {
		return testRepository.findOne(id);
	}

//	public List<Test> findByProviderName(String providerName) {
//		return testRepository.findByProviderName(providerName);
//	}

}
