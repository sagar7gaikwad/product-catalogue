package com.hcl.productcatalogue.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.controller.ProductController;
import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.dto.ProductEvent;
import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.service.ProductConsumer;
import com.hcl.productcatalogue.service.UpdateProductInDBService;


@Service
public class ProductConsumerImpl implements ProductConsumer {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	UpdateProductInDBService updateProductInDBService;
	
	//@JmsListener(destination = "inbound.queue") //NoSonar
	@Override
	public void receiveMessage(ProductEvent productDTOList) throws ApplicationException {
		logger.info("Received update product request data from producer");
		for (ProductDTO productDTO : productDTOList.getProductDTO()) {
			updateProductInDBService.updateLatestProductDetailsInDB(productDTO);
		}
	}

}
