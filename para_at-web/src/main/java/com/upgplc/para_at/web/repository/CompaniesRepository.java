package com.upgplc.para_at.web.repository;

import org.springframework.data.repository.CrudRepository;

import com.upgplc.para_at.web.model.Company;

public interface CompaniesRepository extends CrudRepository<Company, Long> {
	// no explicit methods
}
