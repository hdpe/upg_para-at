package com.upgplc.para_at.at.util;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import static java.util.Arrays.asList;

public class JsonClientHttpRequestInterceptor implements ClientHttpRequestInterceptor {

	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
		throws IOException {
		HttpRequestWrapper wrapped = new HttpRequestWrapper(request);
		wrapped.getHeaders().put("Content-Type", asList(MediaType.APPLICATION_JSON_UTF8_VALUE));
		wrapped.getHeaders().put("Accept", asList(MediaType.APPLICATION_JSON_VALUE));
		return execution.execute(wrapped, body);
	}
}