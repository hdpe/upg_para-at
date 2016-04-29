package com.upgplc.para_at.at;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.upgplc.para_at.at.context.LogEntriesResourceUris;
import com.upgplc.para_at.at.util.JsonClientHttpRequestInterceptor;
import com.upgplc.para_at.at.util.SimpleRestResourceUris;

import static java.util.Arrays.asList;

@Configuration
@ComponentScan
public class AtConfig {

	private String baseUri = "http://localhost:8080";

	@Bean
	public int numberOfThreads() {
		return 4;
	}
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setInterceptors(asList(new JsonClientHttpRequestInterceptor()));
		return restTemplate;
	}
	
	@Bean
	public SimpleRestResourceUris companiesUris() {
		return new SimpleRestResourceUris(baseUri, "companies");
	}
	
	@Bean
	public SimpleRestResourceUris taxisUris() {
		return new SimpleRestResourceUris(baseUri, "taxis");
	}
	
	@Bean
	public SimpleRestResourceUris journeysUris() {
		return new SimpleRestResourceUris(baseUri, "journeys");
	}
	
	@Bean
	public LogEntriesResourceUris logEntriesUris() {
		return new LogEntriesResourceUris(baseUri);
	}
}
