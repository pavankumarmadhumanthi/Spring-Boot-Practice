package com.example.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class AcceptorService {

	public String getProviderData() {
		String url = "http://localhost:9090/getdata";
		
		WebClient wc = WebClient.builder().defaultHeaders(header -> header.setBasicAuth("pavan", "pavan@123")).build();
		return wc.get().uri(url).retrieve().bodyToMono(String.class).block();

	}

}
