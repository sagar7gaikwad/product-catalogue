package com.hcl.productcatalogue.service;

import java.util.List;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.exception.ApplicationException;

public interface ProductConsumer {
	
	public void receiveMessage(List<ProductDTO> productDTO) throws ApplicationException;

}
