package unit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import constants.KeyConfig;
import constants.Profile;
import utils.ExcelUtility;
import utils.ReadConfig;

public class ExcelOps {

	@Test
	public void read_n_writeExcel() throws IOException {
		// Book, Sheet, Row, Cell
		FileOutputStream outputStream = new FileOutputStream("src/main/resources/AAATestData.xlsx");

		Workbook book = // new
						// XSSFWorkbook(getClass().getClassLoader().getResourceAsStream("AAATestData.xlsx"));
				WorkbookFactory.create(getClass().getClassLoader().getResourceAsStream("AAATestData.xlsx"));
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(2);
		System.out.println(cell.getStringCellValue());

		Cell cell2 = row.createCell(3);
		cell2.setCellValue("Failed");
		book.write(outputStream);

		book.close();
	}

	@Test
	public void createDataStructure() throws EncryptedDocumentException, IOException {
		Workbook book = new XSSFWorkbook(getClass().getClassLoader().getResourceAsStream("AAATestData.xlsx"));
		Sheet sheet = book.getSheet("Sheet1");

		int totalRows = sheet.getLastRowNum();
		System.out.println();
		System.out.println(sheet.getRow(0).getLastCellNum());// only exception that read from 1 not as array start from
																// 0

		List<Map<String, String>> list = new ArrayList<>();
		
		for (int i = 1; i <= totalRows; i++) {
			Map <String, String> map = new HashMap<>();
			for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
				try {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				} catch (NullPointerException e) {
				}
			}
			list.add(map);
		}
		
		for(Map<String, String> map : list) {
			System.out.println(map);
		}
	}
	
	@Test
	public void unit_test_excel_util() {
		ReadConfig config = new ReadConfig(Profile.GENERAL);
		String excelPatString = config.getValue(KeyConfig.excelPath);
		String excelSheetString = config.getValue(KeyConfig.excelSheet);
		
		ExcelUtility excelUtility = new ExcelUtility(excelPatString, excelSheetString);
		System.out.println(excelUtility.getTestData().size());
	}
}
