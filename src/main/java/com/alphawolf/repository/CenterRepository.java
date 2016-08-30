package com.alphawolf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alphawolf.model.Center;

@Repository("centerRepository")
public interface CenterRepository extends JpaRepository<Center, Long> {

}
