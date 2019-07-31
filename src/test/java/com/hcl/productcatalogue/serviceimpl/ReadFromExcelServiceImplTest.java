package com.hcl.productcatalogue.serviceimpl;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.productcatalogue.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ReadFromExcelServiceImplTest {

	@InjectMocks
	ReadFromExcelServiceImpl readFromExcelServiceImpl;
	
	@Mock
	ProductRepository productRepository;
	
	@Before
	public void setUp() {
		
	}
	
	@Test
	public void testReadProductsIfFileIsHavingProducts() {
		assertNotNull(readFromExcelServiceImpl.readProducts());
	}
}
