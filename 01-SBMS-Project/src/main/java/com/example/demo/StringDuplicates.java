package com.example.demo;

import java.util.Arrays;

public class StringDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] str= new String[] {"pavan","a",null,"kumar",null,"ab"};
		Arrays.stream(str)
		.filter(e -> e == null || (e != null && e.length() < 3))
		.forEach(e->System.out.println(e));
		

	}

}
