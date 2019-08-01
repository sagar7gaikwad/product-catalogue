package com.hcl.productcatalogue.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.productcatalogue.service.ReadFromExcelService;

//NoSonar
@RunWith(MockitoJUnitRunner.class)
public class ReadFromExcelControllerTest {

	@InjectMocks
	ReadFromExcelController readFromExcelController;
	
	@Mock
	ReadFromExcelService readFromExcelService;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testReadProductsIfFileIsHavingProducts() {
		readFromExcelController.readProducts();
	}
}