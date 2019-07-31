package com.hcl.productcatalogue.serviceimpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.productcatalogue.entity.Product;
import com.hcl.productcatalogue.repository.ProductRepository;
import com.hcl.productcatalogue.service.ReadFromExcelService;

@Service
public class ReadFromExcelServiceImpl implements ReadFromExcelService {

	@Autowired
	ProductRepository productRepository;

	@SuppressWarnings({ "rawtypes" })
	public List<Product> readProducts() {
		// An excel file name. You can create a file name with a full path information.

		String filename = "C:\\Users\\Administrator\\Desktop\\products.xlsx";

		FileInputStream fis = null;
		List<Product> proList = new ArrayList<Product>();

		try {

			// Create a FileInputStream that will be use to read the excel file.
			fis = new FileInputStream(filename);

			// Create an excel workbook from the file system.
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// Get the first sheet on the workbook.
			XSSFSheet sheet = workbook.getSheetAt(0);

			// When we have a sheet object in hand we can iterator on
			// each sheet's rows and on each row's cells. We store the
			// data read on an ArrayList so that we can printed the
			// content of the excel to the console.

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
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return proList;
	}

}
