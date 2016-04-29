package com.upgplc.para_at.at.context;


public class LogEntriesResourceUris {

	private String baseUri;

	public LogEntriesResourceUris(String baseUri) {
		this.baseUri = baseUri;
	}
	
	public String getAll(long taxiId) {
		return baseUri + "/logEntries?taxiId=" + taxiId;
	}
}
