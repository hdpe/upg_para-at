package com.upgplc.para_at.client.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class GetLogEntriesResult {

	private List<GetLogEntriesResultEntry> entries = new ArrayList<>();

	@SuppressWarnings("unused")
	private GetLogEntriesResult() {
		// for Jackson
	}
	
	public GetLogEntriesResult(Collection<GetLogEntriesResultEntry> entries) {
		this.entries.addAll(entries);
	}
	
	public List<GetLogEntriesResultEntry> getEntries() {
		return unmodifiableList(entries);
	}
}
