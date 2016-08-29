package com.alphawolf.service;

import java.util.List;

import com.alphawolf.model.Center;

public interface CenterService {
	
	Center save(Center center);
	Center findById(Long id);
	List<Center> findAllCenters();
}
