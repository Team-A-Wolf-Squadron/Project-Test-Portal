package com.alphawolf.service;

import java.util.List;

import com.alphawolf.model.StudentTest;

public interface StudentTestService {

	
	StudentTest save(StudentTest test);
	List<StudentTest> findAllTest();


	
}
