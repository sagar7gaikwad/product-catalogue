package com.hcl.productcatalogue.serviceimpl;

import javax.jms.ConnectionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.controller.ProductController;
import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.dto.ProductEvent;
import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.service.UpdateProductInDBService;

@Service
public class ProductConsumerImplScheduler {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	UpdateProductInDBService updateProductInDBService;

	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	ConnectionFactory connectionFactory;

	@Scheduled(fixedRate = 60000)
	public void receiveMessage() throws ApplicationException {
		ProductEvent event = (ProductEvent) jmsTemplate.receiveAndConvert("inbound.queue");

		logger.info("Received update product request data from producer");
		for (ProductDTO productDTO : event.getProductDTO()) {
			updateProductInDBService.updateLatestProductDetailsInDB(productDTO);
		}

	}

}
