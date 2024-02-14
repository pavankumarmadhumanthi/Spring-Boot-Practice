package com.example.bindings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Passenger {
	private String name;
	private String email;
	private String from;
	private String to;
	private String doj;
	private String trainNum;

}
