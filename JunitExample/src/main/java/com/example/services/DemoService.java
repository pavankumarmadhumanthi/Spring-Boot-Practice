package com.example.services;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

	public String msg() {
		return "Hello everyone";
	}

	public String greet(String str) {
		System.out.println(str);
		System.out.println(str.length());
		return str;
	}

	public boolean isPalindrone(String str) {
		String reverse = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse = reverse.concat(str.charAt(i) + "");
		}
		return str.equals(reverse) ? true : false;
	}

	public void printData(String str) {
		System.out.println(str);
	}
	
	private String getData(String str) {
		return str;
	}

}
