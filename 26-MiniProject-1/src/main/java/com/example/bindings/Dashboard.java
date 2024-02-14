package com.example.bindings;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Dashboard {
	public Integer total;
	public Integer enrolled;
	public Integer lost;

}
