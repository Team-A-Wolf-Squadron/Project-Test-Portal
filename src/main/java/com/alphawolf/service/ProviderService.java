package com.alphawolf.service;

import java.util.List;

import com.alphawolf.model.Provider;


public interface ProviderService {

	List<Provider> findAllProviders();

	Provider save(Provider provider);

	Provider findByProviderName(String name);
	
	Provider findById(Long id);
	
}
