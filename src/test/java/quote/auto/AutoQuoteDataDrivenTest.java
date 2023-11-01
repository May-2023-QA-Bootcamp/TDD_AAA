package quote.auto;

import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import dto.HomePageDTO;

import static constants.KeyConfig.*;
import utils.ExcelUtility;

public class AutoQuoteDataDrivenTest extends TestBase{

	@DataProvider(name = "excel-data-map")
	public Iterator<Map<String, String>> getDataMap(){
		ExcelUtility excel = new ExcelUtility(config.getValue(excelPath), config.getValue(excelSheet));
		return excel.getTestData().iterator();
	}
	
	
	@Test(dataProvider = "excel-data-map")
	public void getAutoQuote(Map<String, String> map) {
		homePage.verifyTitleText(map.get("Title"));
		homePage.inputZipCodeField(map.get("Zip"));
		homePage.clickSubmitBtn();
		homePage.verifyHomePageTitleText(getDriver(),map.get("Home Title"));
	}
	
	
	@DataProvider(name = "excel-data-pojo-dto")
	public Object[][] getDataDTO(){
		ExcelUtility excel = new ExcelUtility(config.getValue(excelPath), config.getValue(excelSheet));
		Object[][] objects = new Object[excel.getTestData().size()][1];
		
		int i = 0;
		for(Map<String, String> map : excel.getTestData()) {
			HomePageDTO homePageDTO = new HomePageDTO(map.get("Title"), map.get("Zip"), map.get("Home Title"));
			objects[i][0] = homePageDTO;
			i++;
		}
		
		return objects;
	}
	
	@Test(dataProvider = "excel-data-pojo-dto", enabled = true)
	public void getQuoteTestPOJO_DTO(HomePageDTO dto) {
		homePage.verifyTitleText(dto.getTitle());
		homePage.inputZipCodeField(dto.getZipCode());
		homePage.clickSubmitBtn();
		homePage.verifyHomePageTitleText(getDriver(), dto.getHomepageTitle());
	}
}
