package com.upgplc.para_at.at.context;

import org.jbehave.core.annotations.AfterScenario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.upgplc.para_at.at.driver.CompaniesApiDriver;
import com.upgplc.para_at.at.driver.JourneysApiDriver;
import com.upgplc.para_at.at.driver.TaxisApiDriver;

@Component
public class Hooks {

	@Autowired
	private Universe universe;
	
	@Autowired
	private CompaniesApiDriver companies;
	
	@Autowired
	private TaxisApiDriver taxis;
	
	@Autowired
	private JourneysApiDriver journeys;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ResourcesUris resources;
	
	@AfterScenario
	public void afterScenario() {
		for (Long id : universe.journeyIds().getAll()) {
			restTemplate.delete(resources.journeys().delete(id));
		}
		universe.journeyIds().clear();
		
		for (Long id : universe.taxiIds().getAll()) {
			restTemplate.delete(resources.taxis().delete(id));
		}
		universe.taxiIds().clear();
		
		for (Long id : universe.companyIds().getAll()) {
			restTemplate.delete(resources.companies().delete(id));
		}
		universe.companyIds().clear();
	}
}
