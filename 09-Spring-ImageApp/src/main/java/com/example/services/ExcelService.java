package com.example.services;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Person;
import com.example.PersonRepo;

@Service
public class ExcelService {
	@Autowired
	private PersonRepo repo;
	
	@SuppressWarnings("resource")
	public void generateExcel() {
		List<Person> persons = repo.findAll();
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		 int rowNum = 0;
	        for (Person person : persons) {
	            XSSFRow row = sheet.createRow(rowNum++);
	           
	            row.createCell(0).setCellValue(person.getId());
	            row.createCell(1).setCellValue(person.getName());
	            row.createCell(2).setCellValue(person.getPhone());
	        }

	        // Write the workbook content to a file
	        try (FileOutputStream outputStream = new FileOutputStream("data.xlsx")) {
	            workbook.write(outputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		
	}
	
	


