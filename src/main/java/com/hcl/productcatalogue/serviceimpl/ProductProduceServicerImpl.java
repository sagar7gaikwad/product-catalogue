package com.hcl.productcatalogue.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.service.ProductProducerService;

@Service
public class ProductProduceServicerImpl implements ProductProducerService  {

	@Autowired
	JmsTemplate jmsTemplate ;
	
	public void sendProduct(List<ProductDTO> productList) throws ApplicationException {
		 try {
		 jmsTemplate.convertAndSend("inbound.queue", productList);
		 }catch (Exception e) {
			 throw new ApplicationException("Internal system error");
		}
	}
}
