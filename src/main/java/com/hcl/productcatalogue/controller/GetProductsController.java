package com.hcl.productcatalogue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.productcatalogue.dto.ResponseDTO;
import com.hcl.productcatalogue.serviceimpl.GetProductServiceImpl;

@RestController
@RequestMapping("/products")
public class GetProductsController {

	@Autowired
	GetProductServiceImpl getProductServiceImpl;
	
	@GetMapping
	public ResponseEntity<ResponseDTO> getAllProducts() {
		
		
		ResponseDTO returnedResponse = getProductServiceImpl.getAllProducts();
		
		return new ResponseEntity<>(returnedResponse, HttpStatus.OK);

	}
}
