package com.hcl.productcatalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.productcatalogue.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
