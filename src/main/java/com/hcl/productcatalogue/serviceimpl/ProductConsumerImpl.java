package com.hcl.productcatalogue.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.service.ProductConsumer;
import com.hcl.productcatalogue.service.UpdateProductInDBService;

@Service
public class ProductConsumerImpl implements ProductConsumer {

	@Autowired
	UpdateProductInDBService updateProductInDBService;
	
	@JmsListener(destination = "inbound.queue")
	@Override
	public void receiveMessage(List<ProductDTO> productDTO) throws ApplicationException {
		productDTO.forEach(i -> {
			try {
				 updateProductInDBService.updateLatestProductDetailsInDB(i);
			} catch (ApplicationException e) {
				e.printStackTrace();
			}
		});
		
		
		 
	}

}
