package com.hcl.productcatalogue.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.dto.ResponseDTO;
import com.hcl.productcatalogue.entity.Product;
import com.hcl.productcatalogue.repository.ProductRepository;
import com.hcl.productcatalogue.service.GetProductService;
@Service
public class GetProductServiceImpl implements GetProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Override
	public ResponseDTO getAllProducts() {
		
		List<Product> productList = productRepository.getAllOrderByProductVersionDsc();
		System.out.println(productList);
		
		ResponseDTO responseList = new ResponseDTO();
		responseList.setHttpStatus(HttpStatus.OK);
		responseList.setMessage("List Of Latest Product Catalogue");
		responseList.setData(productList);
		
		return responseList;
	}

	
}
