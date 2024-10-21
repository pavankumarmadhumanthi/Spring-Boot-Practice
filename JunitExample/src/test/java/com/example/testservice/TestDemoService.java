package com.example.testservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Method;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.expression.spel.ast.OperatorPower;

import com.example.services.DemoService;
@SpringBootTest
public class TestDemoService {
	public static DemoService service=null;
	@BeforeAll
	public static void getService() {
		if(service==null) {
			service=new DemoService();
		}
	}
	@AfterAll
	public static void nullService() {
		if(service!=null) {
			service=null;
		}
	}
	@Test
	public  void msgTest() {
		DemoService service =new DemoService();
		String result=service.msg();
		assertEquals("Hello everyone",result);	
	}
	@Test
	public void greetTest() {
				String greet = service.greet("hello");
		assertEquals("hello", greet);
	}
	@ParameterizedTest
	@ValueSource(strings={"pavan","kumar","naveen","ramu"})
	public void Testgreet(String str) {
		String greet = service.greet(str);
		assertEquals(String.class,greet.getClass());
	}
	@ParameterizedTest
	@CsvSource({"racecar,true","liril,true","pavan,false"})
	public void isPalindroneTest(String str,boolean value) {
		boolean palindrone = service.isPalindrone(str);
		assertEquals(value,palindrone);
		
	}
//	@ParameterizedTest
//	@ValueSource(strings = {"Hello","pavan","kumar","raju"})
//	public void testPrintData(String str) {
//		service.printData(str);
//		System.out.println(str+"");
//		
//	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Hello","pavan","kumar","raju"})
	public void testGetData(String str) throws Throwable, SecurityException{
		Class<DemoService> class1 = (Class<DemoService>) service.getClass();
		Method declaredMethod = class1.getDeclaredMethod("getData", String.class);
		declaredMethod.setAccessible(true);
		String invoke = (String) declaredMethod.invoke(service, str);
		assertEquals(String.class,String.class);
		
	}
}
