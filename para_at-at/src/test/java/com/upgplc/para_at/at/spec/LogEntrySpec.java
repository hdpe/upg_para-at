package com.upgplc.para_at.at.spec;

import org.hamcrest.Matcher;
import org.jbehave.core.steps.Parameters;

import com.upgplc.para_at.client.model.GetLogEntriesResultEntry;

import static org.hamcrest.Matchers.is;
import static org.hobsoft.hamcrest.compose.ComposeMatchers.compose;
import static org.hobsoft.hamcrest.compose.ComposeMatchers.hasFeature;

public class LogEntrySpec {

	private String registration;
	
	private int journeyLength;

	public LogEntrySpec(Parameters params) {
		this.registration = params.valueAs("registration", String.class);
		this.journeyLength = params.valueAs("journeyLength", Integer.class);
	}
	
	public Matcher<GetLogEntriesResultEntry> matchingEntry() {
		return compose("a log entry with", 
			hasFeature("registration", GetLogEntriesResultEntry::getRegistration, is(registration))).and(
				hasFeature("journeyLength", GetLogEntriesResultEntry::getJourneyLength, is(journeyLength)));
	}
}
