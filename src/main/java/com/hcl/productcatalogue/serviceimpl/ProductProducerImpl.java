package com.hcl.productcatalogue.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.service.ProductProducer;

@Service
public class ProductProducerImpl implements ProductProducer  {

	@Autowired
	JmsTemplate jmsTemplate ;
	
	public void sendProduct(List<ProductDTO> productList) {
		 jmsTemplate.convertAndSend("jms.message.endpoint", productList);
	}
}
