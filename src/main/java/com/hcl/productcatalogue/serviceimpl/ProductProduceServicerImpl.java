package com.hcl.productcatalogue.serviceimpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.controller.ProductController;
import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.dto.ProductEvent;
import com.hcl.productcatalogue.dto.ResponseDTO;
import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.service.ProductProducerService;

@Service
public class ProductProduceServicerImpl implements ProductProducerService {

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	JmsTemplate jmsTemplate;

	public ResponseDTO sendProduct(List<ProductDTO> productList) throws ApplicationException {
		
		ResponseDTO responseDTO = new ResponseDTO();
		ProductEvent event = new ProductEvent();
		event.setProductDTO(productList);
		logger.info("Sending update product request data to listener");
		
		jmsTemplate.convertAndSend("inbound.queue", event);
		logger.info("Sent update product request data to listener");
		responseDTO.setHttpStatus(HttpStatus.OK);
		responseDTO.setMessage("Product List updated sucessfully");
		responseDTO.setData(productList);
		return responseDTO;
	}
}
