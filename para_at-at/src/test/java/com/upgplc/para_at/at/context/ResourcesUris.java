package com.upgplc.para_at.at.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.upgplc.para_at.at.util.SimpleRestResourceUris;

@Component
public class ResourcesUris {

	@Autowired
	private SimpleRestResourceUris companiesUris;
	
	@Autowired
	private SimpleRestResourceUris taxisUris; 
	
	@Autowired
	private SimpleRestResourceUris journeysUris;
	
	@Autowired
	private LogEntriesResourceUris logEntriesUris;
	
	public SimpleRestResourceUris companies() {
		return companiesUris;
	}
	
	public SimpleRestResourceUris taxis() {
		return taxisUris;
	}
	
	public SimpleRestResourceUris journeys() {
		return journeysUris;
	}
	
	public LogEntriesResourceUris logEntries() {
		return logEntriesUris;
	}
}
