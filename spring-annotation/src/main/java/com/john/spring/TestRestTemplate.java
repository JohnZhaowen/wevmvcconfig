package com.john.spring;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class TestRestTemplate {
	
	public static void main(String[] args) {
		
		RestTemplate t = new RestTemplate();
		
		String url = "http://10.0.68.45:9011/shop_iot";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		MultiValueMap<String, String> params= new LinkedMultiValueMap<String, String>();
		params.add("type", "1");
		params.add("img_id", "1");
		params.add("value", "1");
		
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, headers);
		ResponseEntity<String> response = t.exchange(url, HttpMethod.POST, requestEntity, String.class);
		
		
		System.out.println(response.getBody());
	}
}
