package com.upgplc.para_at.at.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upgplc.para_at.at.context.ResourcesUris;

import static com.upgplc.para_at.at.util.RestUtils.getIdFromLocation;

@Component
public class JourneysApiDriver {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ResourcesUris resources;
	
	public long create(long taxiId, int journeyLength) {
		return getIdFromLocation(restTemplate.postForLocation(resources.journeys().post(),
			createRequestEntity(taxiId, journeyLength)));
	}

	public void delete(long id) {
		restTemplate.delete(resources.journeys().delete(id));
	}
	
	private Object createRequestEntity(long taxiId, int journeyLength) {
		ObjectNode request = JsonNodeFactory.instance.objectNode();
		request.put("length", journeyLength);
		request.put("taxi", resources.taxis().get(taxiId));
		return request;
	}
}
