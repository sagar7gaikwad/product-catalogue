package com.hcl.productcatalogue.service;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.exception.ApplicationException;

public interface UpdateProductInDBService {

	/**
	 * @param productDTO
	 * @return success message
	 * @throws ApplicationException
	 */
	public String updateLatestProductDetailsInDB(ProductDTO productDTO) throws ApplicationException;
}
