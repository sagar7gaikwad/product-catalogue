package com.hcl.productcatalogue.serviceimpl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

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
public class GetProductServiceImplTest {

	@InjectMocks
	GetProductServiceImpl getProductServiceImpl;

	@Mock
	ProductRepository productRepository;

	ProductDTO productDTO;

	@Before
	public void setUp() {
		productDTO = new ProductDTO();
	}

	@Test
	public void testGetAllProductsifProductListIsNotEmptyInDB() throws ApplicationException {
		Product product = new Product();
		product.setName("Mobile");
		product.setCategory("Electronics");
		product.setPrice(Double.valueOf(15000.0));
		product.setQuantity(25);
		List<Product> productList = new ArrayList<>();
		productList.add(product);
		List<ProductDTO> productDTOList = new ArrayList<>();
		productDTOList.add(productDTO);
		when(productRepository.getAllOrderByProductVersionDsc()).thenReturn(productList);
		assertNotNull(getProductServiceImpl.getAllProducts());
	}

}
