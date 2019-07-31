package com.hcl.productcatalogue.serviceimpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.entity.Product;
import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class UpdateProductInDBServiceImplTest {

	@InjectMocks
	UpdateProductInDBServiceImpl updateProductInDBServiceImpl;
	
	@Mock
	ProductRepository productRepository;
	
	ProductDTO productDTO;
	
	@Before
	public void setUp() {
		productDTO = new ProductDTO();
	}
	
	@Test
	public void testUpdateLatestProductDetailsInDBIfProductIsPresentInDB() throws ApplicationException {
		Product newProduct = new Product();
		newProduct.setProductVersion(1);
		newProduct.setCategory("Electronics");
		newProduct.setPrice(Double.valueOf(12000.0));
		newProduct.setQuantity(2);
		productDTO.setName("Mobile");
		productDTO.setCategory("Electronics");
		productDTO.setPrice(Double.valueOf(12500.0));
		productDTO.setQuantity(2);
		
		Optional<Product> product = Optional.of(newProduct);
		when(productRepository.getLatestProductByProductName(productDTO.getName())).thenReturn(product);
		assertEquals("Product Details updated Successfully",updateProductInDBServiceImpl.updateLatestProductDetailsInDB(productDTO));
	}
	
	@Test
	public void testUpdateLatestProductDetailsInDBIfProductIsNotPresentInDB() throws ApplicationException {
		Product newProduct = new Product();
		newProduct.setProductVersion(1);
		productDTO.setName("Mobile");
		productDTO.setCategory("Electronics");
		productDTO.setPrice(Double.valueOf(12500.0));
		productDTO.setQuantity(2);
		
		Optional<Product> product = Optional.empty();
		when(productRepository.getLatestProductByProductName(productDTO.getName())).thenReturn(product);
		assertEquals("Product Details updated Successfully",updateProductInDBServiceImpl.updateLatestProductDetailsInDB(productDTO));
	}
	
	@Test(expected = ApplicationException.class)
	public void testUpdateLatestProductDetailsInDBIfProductDTOIsNull() throws ApplicationException {
		
		assertNull(updateProductInDBServiceImpl.updateLatestProductDetailsInDB(null));
	}
	
	@Test
	public void testUpdateLatestProductDetailsInDBIfProductIsPresentInDBWithSameDetails() throws ApplicationException {
		Product newProduct = new Product();
		newProduct.setProductVersion(1);
		newProduct.setCategory("Electronics");
		newProduct.setPrice(Double.valueOf(12500.0));
		newProduct.setQuantity(2);
		productDTO.setName("Mobile");
		productDTO.setCategory("Electronics");
		productDTO.setPrice(Double.valueOf(12500.0));
		productDTO.setQuantity(2);
		
		Optional<Product> product = Optional.of(newProduct);
		when(productRepository.getLatestProductByProductName(productDTO.getName())).thenReturn(product);
		assertEquals("Product Details updated Successfully",updateProductInDBServiceImpl.updateLatestProductDetailsInDB(productDTO));
	}
}
