package com.alphawolf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alphawolf.model.StudentTest;

@Repository("studentTestRepository")
public interface StudentTestRepository extends JpaRepository<StudentTest, Long> {

}
