package com.hcl.productcatalogue.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.repository.ProductRepository;
import com.hcl.productcatalogue.service.UpdateProductInDBService;

@Service
public class UpdateProductInDBServiceImpl implements UpdateProductInDBService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public String updateLatestProductDetailsInDB(ProductDTO productDTO) throws ApplicationException {
		if(null == productDTO) {
			throw new ApplicationException("No product received");
		}
		
		return null;
	}

	
}
