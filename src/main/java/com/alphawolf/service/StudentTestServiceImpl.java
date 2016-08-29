package com.alphawolf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alphawolf.model.StudentTest;
import com.alphawolf.repository.StudentTestRepository;

@Service("studentTestService")
public class StudentTestServiceImpl implements StudentTestService {

	@Autowired
	private StudentTestRepository studentTestRepository;
	
	@Transactional
	public StudentTest save(StudentTest test) {
		return studentTestRepository.save(test);
	}

	public List<StudentTest> findAllTest() {
		return studentTestRepository.findAll();
	}

}
