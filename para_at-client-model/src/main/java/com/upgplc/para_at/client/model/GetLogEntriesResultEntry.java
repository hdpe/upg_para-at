package com.upgplc.para_at.client.model;

public class GetLogEntriesResultEntry {

	private String registration;
	
	private int journeyLength;

	@SuppressWarnings("unused")
	private GetLogEntriesResultEntry() {
		// for Jackson
	}
	
	public GetLogEntriesResultEntry(String registration, int journeyLength) {
		this.registration = registration;
		this.journeyLength = journeyLength;
	}
	
	public String getRegistration() {
		return registration;
	}
	
	public int getJourneyLength() {
		return journeyLength;
	}
}
