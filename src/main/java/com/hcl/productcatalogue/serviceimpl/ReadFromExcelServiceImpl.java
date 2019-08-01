package com.hcl.productcatalogue.serviceimpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.entity.Product;
import com.hcl.productcatalogue.repository.ProductRepository;
import com.hcl.productcatalogue.service.ReadFromExcelService;

@Service
public class ReadFromExcelServiceImpl implements ReadFromExcelService {

	private static final Logger logger = LoggerFactory.getLogger(ReadFromExcelServiceImpl.class);

	private static final String FILENAME =  "C:\\Users\\Administrator\\Desktop\\products.xlsx";
	@Autowired
	ProductRepository productRepository;

	@SuppressWarnings({ "rawtypes" })
	public List<Product> readProducts() {
		// An excel file name. You can create a file name with a full path information.


		// Create an ArrayList to store the data read from excel sheet.

		List<Product> proList = new ArrayList<>();

		try (FileInputStream fis = new FileInputStream(FILENAME); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			XSSFSheet sheet = workbook.getSheetAt(0);

			productRepository.deleteAll();

			Iterator rows = sheet.rowIterator();
			while (rows.hasNext()) {
				XSSFRow row = (XSSFRow) rows.next();
				Product prod = new Product();
				prod.setName(row.getCell(0).toString());
				prod.setQuantity((int) Double.parseDouble(row.getCell(3).toString()));
				prod.setPrice(Double.parseDouble(row.getCell(2).toString()));
				prod.setCategory(row.getCell(1).toString());

				productRepository.save(prod);
				proList.add(prod);

			}
		} catch (IOException e) {
			logger.info(e.getMessage());
		}

		return proList;
	}

}
