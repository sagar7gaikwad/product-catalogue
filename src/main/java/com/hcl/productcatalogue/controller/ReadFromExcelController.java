package com.hcl.productcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.productcatalogue.service.ReadFromExcelService;

@RestController
public class ReadFromExcelController {
	
	
	@Autowired
	ReadFromExcelService readFromExcelService;

	
	@PostMapping("")
	public void readProducts()  {
		readFromExcelService.readProducts();
		 
	}		
}
