package com.upgplc.para_at.at.spec;

import org.jbehave.core.steps.Parameters;

public class TaxiSpec {

	private String registration;
	
	public TaxiSpec(Parameters params) {
		registration = params.valueAs("registration", String.class);
	}

	public String getRegistration() {
		return registration;
	}
}
