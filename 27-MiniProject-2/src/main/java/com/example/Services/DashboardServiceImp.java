package com.example.Services;

import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Bindings.Dashboard;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class DashboardServiceImp implements DashboardService {
	private Dashboard[] quotes=null;
	String url = "https://type.fit/api/quotes";
	@Override
	public Dashboard getQuote(){
		if(quotes==null) {
			RestTemplate template=new RestTemplate();
			ResponseEntity<String> forEntity = template.getForEntity(url,String.class);
			String body = forEntity.getBody();
			ObjectMapper mapper=new ObjectMapper();
			
			try {
				quotes = mapper.readValue(body,Dashboard[].class);
			} catch (Exception e) {
				e.printStackTrace();
			
			}
			
		}
		Random r =new Random();
		int nextInt = r.nextInt(quotes.length-1);
		return quotes[nextInt];

	}

}
