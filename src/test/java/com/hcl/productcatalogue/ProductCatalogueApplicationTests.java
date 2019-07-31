package com.hcl.productcatalogue;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCatalogueApplicationTests {

	@Test
	public void contextLoads() {
		String sample = "Hello";
		assertEquals("Hello", sample);
	}

}
