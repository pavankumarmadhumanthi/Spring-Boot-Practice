package com.example.testcontroller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.services.DemoService;

@WebMvcTest
public class TestDemoController {
	
	@MockBean
	private DemoService service;
	
	@Autowired
	private MockMvc mockmvc;
	

	public void testGetMsg() throws Exception {
		when(service.msg()).thenReturn("Dummy String");
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.get("/welcome");
		MvcResult andReturn = mockmvc.perform(req).andReturn();
		MockHttpServletResponse response = andReturn.getResponse();
		int status = response.getStatus();
	}
}
