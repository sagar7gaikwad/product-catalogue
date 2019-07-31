package com.hcl.productcatalogue.serviceimpl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.dto.ProductDTO;
import com.hcl.productcatalogue.entity.Product;
import com.hcl.productcatalogue.exception.ApplicationException;
import com.hcl.productcatalogue.repository.ProductRepository;
import com.hcl.productcatalogue.service.UpdateProductInDBService;

/**
 * @author Administrator
 *
 */
@Service
public class UpdateProductInDBServiceImpl implements UpdateProductInDBService {

	private static final Logger logger = LoggerFactory.getLogger(UpdateProductInDBServiceImpl.class);

	@Autowired
	ProductRepository productRepository;

	/**
	 * @param productDTO
	 * @return success message
	 * @throws ApplicationException
	 */
	@Override
	public String updateLatestProductDetailsInDB(ProductDTO productDTO) throws ApplicationException {
		logger.info("Inside updateLatestProductDetailsInDB method of UpdateProductInDBServiceImpl class");
		if (null == productDTO) {
			throw new ApplicationException("No product received");
		}
		Optional<Product> product = productRepository.getLatestProductByProductName(productDTO.getName());
		Product newProduct = new Product();
		if (!product.isPresent()) {
			productRepository.save(setProductDetails(productDTO, newProduct));
		} else {
			Product dbProduct = product.get();
			if (dbProduct.getPrice().doubleValue() != productDTO.getPrice().doubleValue() || !dbProduct.getCategory().equalsIgnoreCase(productDTO.getCategory())
					|| !dbProduct.getQuantity().equals(productDTO.getQuantity())) {
				newProduct.setProductVersion(product.get().getProductVersion() + 1);
				productRepository.save(setProductDetails(productDTO, newProduct));
			}
		}
		logger.info("exiting updateLatestProductDetailsInDB method of UpdateProductInDBServiceImpl class");
		return "Product Details updated Successfully";
	}

	private Product setProductDetails(ProductDTO productDTO, Product newProduct) {
		newProduct.setCategory(productDTO.getCategory());
		newProduct.setName(productDTO.getName());
		newProduct.setPrice(productDTO.getPrice());
		newProduct.setQuantity(productDTO.getQuantity());
		newProduct.setProductVersion(newProduct.getProductVersion());
		return newProduct;
	}
}
