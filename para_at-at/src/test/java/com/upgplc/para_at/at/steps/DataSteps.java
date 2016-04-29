package com.upgplc.para_at.at.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upgplc.para_at.at.context.Universe;
import com.upgplc.para_at.at.driver.CompaniesApiDriver;
import com.upgplc.para_at.at.driver.JourneysApiDriver;
import com.upgplc.para_at.at.driver.TaxisApiDriver;
import com.upgplc.para_at.at.spec.TaxiSpec;

@Component
public class DataSteps {

	@Autowired
	private CompaniesApiDriver companies;
	
	@Autowired
	private TaxisApiDriver taxis;
	
	@Autowired
	private JourneysApiDriver journies;
	
	@Autowired
	private Universe universe;
	
	@Given("an existing taxi company \"$name\"")
	public void anExistingTaxiCompany(@Named("name") String name) {
		universe.companyIds().put(name, companies.create());
	}
	
	@Given("the following existing taxi \"$taxiName\" for $companyName: $values")
	public void theFollowingExistingTaxiForCompany(@Named("taxiName") String taxiName,
		@Named("companyName") String companyName, @Named("values") ExamplesTable values) {
		TaxiSpec taxi = new TaxiSpec(values.getRowAsParameters(0));
		universe.taxiIds().put(taxiName, taxis.create(taxi, universe.companyIds().get(companyName)));
	}
	
	@When("I log a journey for $taxiName of $length minutes")
	public void iLogAJourneyForTaxiOfLength(@Named("taxiName") String taxiName, @Named("length") int length) {
		universe.journeyIds().put(journies.create(universe.taxiIds().get(taxiName), length));
	}
}
