package com.upgplc.para_at.at.steps;

import org.hamcrest.Matcher;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upgplc.para_at.at.context.Universe;
import com.upgplc.para_at.at.driver.LogEntriesApiDriver;
import com.upgplc.para_at.at.driver.TaxisApiDriver;
import com.upgplc.para_at.at.spec.LogEntrySpec;
import com.upgplc.para_at.client.model.GetLogEntriesResultEntry;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

@Component
public class LogEntrySteps {

	@Autowired
	private TaxisApiDriver taxis;
	
	@Autowired
	private LogEntriesApiDriver logEntries;
	
	@Autowired
	private Universe universe;
	
	@Then("$taxiName has the following log entries: $values")
	public void taxiHasTheFollowingLogEntries(@Named("taxiName") String taxiName,
		@Named("values") ExamplesTable values) {
		Matcher<GetLogEntriesResultEntry>[] expected = values.getRowsAsParameters().stream()
			.map(row -> new LogEntrySpec(row).matchingEntry())
			.toArray(Matcher[]::new);
		
		assertThat(logEntries.getAll(universe.taxiIds().get(taxiName)).getEntries(), contains(expected));
	}
}
