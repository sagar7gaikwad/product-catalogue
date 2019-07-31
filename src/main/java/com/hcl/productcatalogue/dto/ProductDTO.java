package com.hcl.productcatalogue.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductDTO {
	
			private String name;
			
			private String category;
				
			private Double price;
			
			private LocalDateTime productVersion;
		
			private Integer quantity;

		}
		

