package com.hcl.productcatalogue.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.productcatalogue.dto.ResponseDTO;
import com.hcl.productcatalogue.serviceimpl.GetProductServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class GetProductsControllerTest {

	@InjectMocks
	GetProductsController getProductsController;
	
	@Mock
	GetProductServiceImpl getProductServiceImpl;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testGetAllProductsIfProductListIsPresentInDB() {
		when(getProductServiceImpl.getAllProducts()).thenReturn(new ResponseDTO());
		assertNotNull(getProductsController.getAllProducts());
	}
}
