package com.hcl.productcatalogue.service;

import java.util.List;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.dto.ResponseDTO;
import com.hcl.productcatalogue.exception.ApplicationException;

public interface ProductProducerService {
	
	public ResponseDTO sendProduct(List<ProductDTO> productList) throws ApplicationException;

}
