package com.upgplc.para_at.at.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.upgplc.para_at.at.context.ResourcesUris;
import com.upgplc.para_at.at.spec.TaxiSpec;

import static com.upgplc.para_at.at.util.RestUtils.getIdFromLocation;

@Component
public class TaxisApiDriver {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private ResourcesUris resources;
	
	public long create(TaxiSpec taxi, long companyId) {
		return getIdFromLocation(restTemplate.postForLocation(resources.taxis().post(),
			createRequestEntity(taxi, companyId)));
	}

	public void delete(long taxiId) {
		restTemplate.delete(resources.taxis().delete(taxiId));
	}

	private Object createRequestEntity(TaxiSpec taxi, long companyId) {
		ObjectNode request = JsonNodeFactory.instance.objectNode();
		request.put("registration", taxi.getRegistration());
		request.put("company", resources.companies().get(companyId));
		return request.toString();
	}
}
