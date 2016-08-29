package com.alphawolf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alphawolf.model.Provider;

@Repository("providerRepository")
public interface ProviderRepository extends JpaRepository<Provider, Long> {

	Provider findByProviderName(String name);
	
	Provider findById(Long id);
}
