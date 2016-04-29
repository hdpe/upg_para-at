package com.upgplc.para_at.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.upgplc.para_at.web.model.Journey;

public interface JourneysRepository extends CrudRepository<Journey, Long> {
	
	List<Journey> findByTaxiId(long taxiId);
}
