package com.upgplc.para_at.at.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.upgplc.para_at.at.context.ResourcesUris;
import com.upgplc.para_at.client.model.GetLogEntriesResult;

@Component
public class LogEntriesApiDriver {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ResourcesUris resources;
	
	public GetLogEntriesResult getAll(long taxiId) {
		return restTemplate.getForObject(resources.logEntries().getAll(taxiId), GetLogEntriesResult.class);
	}
}
