package com.hcl.productcatalogue.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.productcatalogue.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT * FROM productcatalogue.product where name = :productName order by product_version desc limit 1;",nativeQuery = true)
	public Optional<Product> getLatestProductByProductName(String productName);
	
	@Query(value = "SELECT name,price,max(product_version) FROM product group by name having product_version;", nativeQuery = true)
	List<Product> getAllOrderByProductVersionDsc();
}
