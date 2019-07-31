package com.hcl.productcatalogue.service;

import java.util.List;

import com.hcl.productcatalogue.dto.ProductDTO;

public interface ProductProducer {
	
	public void sendProduct(List<ProductDTO> productList);

}
