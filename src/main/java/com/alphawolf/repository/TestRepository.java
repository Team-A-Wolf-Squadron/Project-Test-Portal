package com.alphawolf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alphawolf.model.Test;

@Repository("testRepository")
public interface TestRepository  extends JpaRepository<Test, Long>{

	//List<Test> findByProviderName(String providerName);

}
