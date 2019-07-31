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
	
	//@Query(value = "SELECT name,price,max(product_version) FROM product group by name having max(product_version);", nativeQuery = true)
	//@Query(value = "SELECT max(product_version), name, price FROM product GROUP BY name HAVING max(product_version) ORDER BY max(product_version) DESC;", nativeQuery = true)
	@Query(value="SELECT p1.* from product p1 inner join  (SELECT name,max(product_version) version FROM product group by name having max(product_version)) as p2 on p1.name = p2.name and p1.product_version = p2.version;",nativeQuery = true)
	List<Product> getAllOrderByProductVersionDsc();
}
