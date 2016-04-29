package com.upgplc.para_at.at.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.upgplc.para_at.at.context.ResourcesUris;

import static com.upgplc.para_at.at.util.RestUtils.getIdFromLocation;

@Component
public class CompaniesApiDriver {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ResourcesUris resources;
	
	public long create() {
		return getIdFromLocation(restTemplate.postForLocation(resources.companies().post(), "{}"));
	}
	
	public void delete(long id) {
		restTemplate.delete(resources.companies().delete(id));
	}
}
