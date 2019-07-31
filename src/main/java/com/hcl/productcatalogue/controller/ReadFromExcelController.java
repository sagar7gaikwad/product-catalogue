package com.hcl.productcatalogue.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.service.ReadFromExcelService;

@RestController
public class ReadFromExcelController {
	
	
	@Autowired
	ReadFromExcelService readFromExcelService;

	
	@GetMapping("")
	public void readProducts() throws ApplicationException, IOException {
		readFromExcelService.readProducts();
		 
	}		
}
