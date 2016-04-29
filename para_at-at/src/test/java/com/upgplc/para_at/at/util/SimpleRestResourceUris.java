package com.upgplc.para_at.at.util;

public class SimpleRestResourceUris {

	private String resourceBaseUri;
	
	public SimpleRestResourceUris(String baseUri, String resourceName) {
		this.resourceBaseUri = baseUri + "/" + resourceName;
	}
	
	public String get(long id) {
		return resourceBaseUri + "/" + id;
	}
	
	public String delete(long id) {
		return get(id);
	}
	
	public String post() {
		return resourceBaseUri;
	}
}
