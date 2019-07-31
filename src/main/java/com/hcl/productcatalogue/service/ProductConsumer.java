package com.hcl.productcatalogue.service;

import com.hcl.productcatalogue.dto.ProductEvent;
import com.hcl.productcatalogue.exception.ApplicationException;

public interface ProductConsumer {
	
	/*
	 * This method is used to get product list from activeMQ and save in database.
	 * @param List of ProductDTO
	 */
	public void receiveMessage(ProductEvent productDTO) throws ApplicationException;

}
