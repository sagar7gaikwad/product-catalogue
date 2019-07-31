package com.hcl.productcatalogue.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.dto.ResponseDTO;
import com.hcl.productcatalogue.entity.Product;
import com.hcl.productcatalogue.repository.ProductRepository;
import com.hcl.productcatalogue.service.GetProductService;
@Service
public class GetProductServiceImpl implements GetProductService {

	@Autowired
	ProductRepository productRepository;
	
	/**
	 * This Method get all the product based on latest version and 
	 * returns the list of products in the form of response object
	 */
	@Override
	public ResponseDTO getAllProducts() {
		
		List<Product> productList = productRepository.getAllOrderByProductVersionDsc();
		
		List<ProductDTO> productResponseDTOList = productList.stream().map(i -> new ProductDTO(i.getName(),i.getCategory()
				,i.getPrice(), i.getQuantity())).collect(Collectors.toList());
		
		ResponseDTO responseList = new ResponseDTO();
		responseList.setHttpStatus(HttpStatus.OK);
		responseList.setMessage("List Of Latest Product Catalogue");
		responseList.setData(productResponseDTOList);
		
		return responseList;
	}

	
}
