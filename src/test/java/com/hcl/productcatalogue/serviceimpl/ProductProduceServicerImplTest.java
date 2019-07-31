package com.hcl.productcatalogue.serviceimpl;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jms.core.JmsTemplate;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.exception.ApplicationException;

@RunWith(MockitoJUnitRunner.class)
public class ProductProduceServicerImplTest {

	@InjectMocks
	ProductProduceServicerImpl productProduceServicerImpl;

	@Mock
	JmsTemplate jmsTemplate;

	ProductDTO productDTO;

	@Before
	public void setUp() {
		productDTO = new ProductDTO();
	}

	@Test
	public void testSendProductifProductListIsNotEmpty() throws ApplicationException {
		List<ProductDTO> productList = new ArrayList<>();
		productList.add(productDTO);
		assertNotNull(productProduceServicerImpl.sendProduct(productList));
	}
}
