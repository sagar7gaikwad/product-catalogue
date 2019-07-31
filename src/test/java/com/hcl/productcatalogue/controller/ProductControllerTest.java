package com.hcl.productcatalogue.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.service.ProductProducerService;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

	@InjectMocks
	ProductController productController;
	
	@Mock
	ProductProducerService productProducerService;
	
	ProductDTO productDTO;

	@Before
	public void setUp() {
		productDTO = new ProductDTO();
	}

	@Test
	public void testUpdateProductIfProductListIsPresent() throws ApplicationException {
		List<ProductDTO> productList = new ArrayList<>();
		productList.add(productDTO);
		assertNotNull(productController.updateProduct(productList));
	
	}
}
