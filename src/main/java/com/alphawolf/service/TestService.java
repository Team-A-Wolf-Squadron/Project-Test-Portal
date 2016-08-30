package com.alphawolf.service;

import java.util.List;

import com.alphawolf.model.Test;

public interface TestService {
	
	Test save(Test test);
	
	List<Test> findAllTest();

	Test findById(Long id);
	
//	Test findByProviderName();
	

}
