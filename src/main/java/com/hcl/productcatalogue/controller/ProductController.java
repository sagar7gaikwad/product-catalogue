package com.hcl.productcatalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.dto.ResponseDTO;
import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.service.ProductProducerService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {	
	private static final String ERROR_MSG = "Mandetory Element missing : ";

	
	@Autowired
	ProductProducerService productProducerService;
	@PutMapping
	public ResponseEntity<ResponseDTO> updateProduct(@RequestBody List<ProductDTO> products ) throws ApplicationException{
		ResponseDTO respDto = null;
		productProducerService.sendProduct(products);
		
		return new ResponseEntity<>(respDto, HttpStatus.OK);
	}
	
}
