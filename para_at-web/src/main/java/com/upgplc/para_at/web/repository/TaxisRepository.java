package com.upgplc.para_at.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.upgplc.para_at.web.model.Taxi;

public interface TaxisRepository extends CrudRepository<Taxi, Long> {
	// no explicit methods
}
