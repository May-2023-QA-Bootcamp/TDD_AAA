package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import reports.Loggers;

public class ExcelUtility {

	String path;
	Workbook workbook;
	Sheet sheet;

	public String getPath() {
		return path;
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public Sheet getSheet() {
		return sheet;
	}

	public ExcelUtility(String path, String sheetName) {
		this.path = path;
		build(sheetName);
	}

	private void build(String sheetName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(getPath());
			if (getPath().endsWith(".xlsx")) {
				workbook = new XSSFWorkbook(fileInputStream);
			} else if (getPath().endsWith(".xls")) {
				workbook = new HSSFWorkbook(fileInputStream);
			}
			sheet = workbook.getSheet(sheetName);
		} catch (IOException e) {
			Loggers.log("File not found at " + getPath());
		} catch (NullPointerException e) {
			Loggers.log("File not passed ");
		}
	}

	public void closeResource() {
		try {
			getWorkbook().close();
		} catch (IOException e) {
			Loggers.log("File not found at " + getPath());
		}
	}

	public List<Map<String, String>> getTestData(){
		List<Map<String, String>> list = new ArrayList<>();
		
		for(int i = 1; i <= getSheet().getLastRowNum(); i++) {
			Map<String, String> map = new HashMap<>();
			for(int j = 0; j < getSheet().getRow(i).getLastCellNum(); j++) {
				try {
					String key 	 = getSheet().getRow(0).getCell(j).getStringCellValue();
					String value = getSheet().getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}catch (NullPointerException e) {
					// TODO: handle exception
				}
			}
			list.add(map);
		}
		
		return list;	
	}
}
