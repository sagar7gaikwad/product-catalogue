package com.hcl.productcatalogue.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.dto.ProductEvent;
import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.service.UpdateProductInDBService;

@RunWith(MockitoJUnitRunner.class)
public class ProductConsumerImplTest {

	@InjectMocks
	ProductConsumerImpl productConsumerImpl;
	
	@Mock
	UpdateProductInDBService updateProductInDBService;

	ProductDTO productDTO;

	@Before
	public void setUp() {
		productDTO = new ProductDTO();
	}

	@Test
	public void testReceiveMessageifProductListIsNotEmpty() throws ApplicationException {
		List<ProductDTO> productList = new ArrayList<>();
		productList.add(productDTO);
		ProductEvent productDTOList = new ProductEvent();
		productDTOList.setProductDTO(productList);
		productConsumerImpl.receiveMessage(productDTOList);
	}
}
