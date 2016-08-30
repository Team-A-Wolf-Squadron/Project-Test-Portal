package com.alphawolf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alphawolf.model.Provider;
import com.alphawolf.repository.ProviderRepository;


@Service("providerService")
public class ProviderServiceImpl implements ProviderService {

	@Autowired
	private ProviderRepository providerRepository;
	
	public List<Provider> findAllProviders() {
		return providerRepository.findAll();
	}

	@Transactional
	public Provider save(Provider provider) {
		return providerRepository.save(provider);
		
	}

	public Provider findByProviderName(String name) {
		return providerRepository.findByProviderName(name);
	}

	public Provider findById(Long id) {
		return providerRepository.findById(id);
	}

}
