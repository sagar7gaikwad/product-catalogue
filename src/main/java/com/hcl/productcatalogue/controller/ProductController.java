package com.hcl.productcatalogue.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	ProductProducerService productProducerService;
	@PutMapping
	public ResponseEntity<ResponseDTO> updateProduct(@RequestBody List<ProductDTO> products ) throws ApplicationException{
		logger.info("Received update product request.");
		return new ResponseEntity<>(productProducerService.sendProduct(products), HttpStatus.OK);
	}
	
}
