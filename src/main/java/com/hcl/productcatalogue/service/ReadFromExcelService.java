package com.hcl.productcatalogue.service;

import java.util.List;

import com.hcl.productcatalogue.entity.Product;

public interface ReadFromExcelService {

	public List<Product> readProducts();
}
