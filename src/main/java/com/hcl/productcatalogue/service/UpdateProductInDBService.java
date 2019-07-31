package com.hcl.productcatalogue.service;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.exception.ApplicationException;

public interface UpdateProductInDBService {

	public String updateLatestProductDetailsInDB(ProductDTO productDTO) throws ApplicationException;
}
