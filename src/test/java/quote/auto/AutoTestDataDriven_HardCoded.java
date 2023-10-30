package quote.auto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import dto.HomePageDTO;

public class AutoTestDataDriven_HardCoded extends TestBase{

	public Object[][] get2D_Data(){
		return new Object[][] {
			new String[] {"Welcome to AAA Northeast","11423","Home | AAA Northeast"},
			new String[] {"Welcome to AAA Northeast","75051","Home | AAA Northeast"},
			new String[] {"Welcome to AAA Northeast","93653","Home | AAA Northeast"},
			new String[] {"Welcome to AAA Northeast","33411","Home | AAA Northeast"},
			new String[] {"Welcome to AAA Northeast","07002","Home | AAA Northeast"}
		};
	}
	
	
	@DataProvider(name = "hard-code-2D")
	public Object[][] dataObjet(){
//		Object[][] arrayOfArrays = new Object[5][3]; // fist box[] is for number of test runs, second box[] total number of params
		
//		String[] arr1 = new String[] {"Welcome to AAA Northeast","11423","Home | AAA Northeast"};
//		arrayOfArrays[0] = arr1;
//		String[] arr2 = new String[] {"Welcome to AAA Northeast","75051","Home | AAA Northeast"};
//		arrayOfArrays[1] = arr2;
//		String[] arr3 = new String[] {"Welcome to AAA Northeast","93653","Home | AAA Northeast"};
//		arrayOfArrays[2] = arr3;
//		String[] arr4 = new String[] {"Welcome to AAA Northeast","33411","Home | AAA Northeast"};
//		arrayOfArrays[3] = arr4;
//		String[] arr5 = new String[] {"Welcome to AAA Northeast","07002","Home | AAA Northeast"};
//		arrayOfArrays[4] = arr5;
//		
//		return arrayOfArrays;
		
		// Both of them are same but in different declaration
		
//		return new Object[][] {
//			new String[] {"Welcome to AAA Northeast","11423","Home | AAA Northeast"},
//			new String[] {"Welcome to AAA Northeast","75051","Home | AAA Northeast"},
//			new String[] {"Welcome to AAA Northeast","93653","Home | AAA Northeast"},
//			new String[] {"Welcome to AAA Northeast","33411","Home | AAA Northeast"},
//			new String[] {"Welcome to AAA Northeast","07002","Home | AAA Northeast"}
//		};
		
		return get2D_Data();
	}
	
	@Test(dataProvider = "hard-code-2D", enabled = true)
	public void getQuoteTest(String title, String zipCode, String homeTitle) {
		homePage.verifyTitleText(title);
		homePage.inputZipCodeField(zipCode);
		homePage.clickSubmitBtn();
		homePage.verifyHomePageTitleText(getDriver(),homeTitle);
	}
	
	
	@DataProvider(name = "hard-code-iterator-obj")
	public Iterator<Object[]> dataIteratorObj(){
		List<Object[]> list = new ArrayList<>();
		
		list.add(new Object[]{"Welcome to AAA Northeast","11423","Home | AAA Northeast"});
		
		list.add(new Object[]{"Welcome to AAA Northeast","75051","Home | AAA Northeast"});
		
		return list.iterator();
	}
	
	@Test(dataProvider = "hard-code-iterator-obj", enabled = true)
	public void getQuoteTestList(String title, String zipCode, String homeTitle) {
		homePage.verifyTitleText(title);
		homePage.inputZipCodeField(zipCode);
		homePage.clickSubmitBtn();
		homePage.verifyHomePageTitleText(getDriver(),homeTitle);
	}
	
	@DataProvider(name = "hard-code-iterator")
	public Iterator<List<String>> dataIterator(){
		List<List<String>> listOfLists = new ArrayList<>();
		
		List<String> testDataList1 = new ArrayList<>();
		testDataList1.add("Welcome to AAA Northeast");
		testDataList1.add("11423");
		testDataList1.add("Home | AAA Northeast");
		listOfLists.add(testDataList1);
		
		List<String> testDataList2 = new ArrayList<>();
		testDataList1.add("Welcome to AAA Northeast");
		testDataList1.add("75051");
		testDataList1.add("Home | AAA Northeast");
		listOfLists.add(testDataList2);
		
		return listOfLists.iterator();
	}
	
	@Test(dataProvider = "hard-code-iterator", enabled = true)
	public void getQuoteTestList(List<String> list) {
		homePage.verifyTitleText(list.get(0));
		homePage.inputZipCodeField(list.get(1));
		homePage.clickSubmitBtn();
		homePage.verifyHomePageTitleText(getDriver(),list.get(2));
	}
	
	
	@DataProvider(name = "hard-code-map")
	public Object[][] dataMap(){
		Object[][] arrays = new Object[3][1];
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("Title", "Welcome to AAA Northeast");
		map1.put("ZipCode", "11423");
		map1.put("Homepage Title", "Home | AAA Northeast");
		arrays[0][0] = map1;
		
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("Title", "Welcome to AAA Northeast");
		map2.put("ZipCode", "75051");
		map2.put("Homepage Title", "Home | AAA Northeast");
		arrays[1][0] = map2;
		
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("Title", "Welcome to AAA Northeast");
		map3.put("ZipCode", "93653");
		map3.put("Homepage Title", "Home | AAA Northeast");
		arrays[2][0] = map3;

		return arrays;
	}
	
	@Test(dataProvider = "hard-code-map", enabled = true)
	public void getQuoteTestMap(Map<String, String> map) {
		homePage.verifyTitleText(map.get("Title"));
		homePage.inputZipCodeField(map.get("ZipCode"));
		homePage.clickSubmitBtn();
		homePage.verifyHomePageTitleText(getDriver(),map.get("Homepage Title"));
	}
	
	
	@DataProvider(name = "hard-code-iterator-map")
	public Iterator<Map<String,String>> dataIteratorMap(){
		List<Map<String,String>> listOfMaps = new ArrayList<>();
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("Title", "Welcome to AAA Northeast");
		map1.put("ZipCode", "11423");
		map1.put("Homepage Title", "Home | AAA Northeast");
		listOfMaps.add(map1);
		
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("Title", "Welcome to AAA Northeast");
		map2.put("ZipCode", "75051");
		map2.put("Homepage Title", "Home | AAA Northeast");
		listOfMaps.add(map2);
		
		return listOfMaps.iterator();
	}
	
	@Test(dataProvider = "hard-code-iterator-map", enabled = false)
	public void getQuoteTestIteratorMap(Map<String, String> map) {
		homePage.verifyTitleText(map.get("Title"));
		homePage.inputZipCodeField(map.get("ZipCode"));
		homePage.clickSubmitBtn();
		homePage.verifyHomePageTitleText(getDriver(),map.get("Homepage Title"));
	}
	
	
	@DataProvider(name = "hard-code-pojo-dto")
	public Object[][] dataDTO(){
		Object[][] arrays = new Object[2][1];
		
		HomePageDTO dto1 = new HomePageDTO("Welcome to AAA Northeast","11423","Home | AAA Northeast");
		arrays[0][0] = dto1;
		
		HomePageDTO dto2 = new HomePageDTO("Welcome to AAA Northeast","75051","Home | AAA Northeast");
		arrays[1][0] = dto2;

		return arrays;
	}
	
	@Test(dataProvider = "hard-code-pojo-dto", enabled = true)
	public void getQuoteTestPOJO_DTO(HomePageDTO dto) {
		homePage.verifyTitleText(dto.getTitle());
		homePage.inputZipCodeField(dto.getZipCode());
		homePage.clickSubmitBtn();
		homePage.verifyHomePageTitleText(getDriver(), dto.getHomepageTitle());
	}
	
	
	@DataProvider(name = "hard-code-pojo-dto-iterator")
	public Iterator<HomePageDTO> dataDTOIterator(){
		List<HomePageDTO> list = new ArrayList<>();
		
		HomePageDTO dto1 = new HomePageDTO("Welcome to AAA Northeast","11423","Home | AAA Northeast");
		list.add(dto1);
		
		HomePageDTO dto2 = new HomePageDTO("Welcome to AAA Northeast","75051","Home | AAA Northeast");
		list.add(dto2);

		return list.iterator();
	}
	
	@Test(dataProvider = "hard-code-pojo-dto-iterator", enabled = true)
	public void getQuoteTestPOJO_DTO_iterator(HomePageDTO dto) {
		homePage.verifyTitleText(dto.getTitle());
		homePage.inputZipCodeField(dto.getZipCode());
		homePage.clickSubmitBtn();
		homePage.verifyHomePageTitleText(getDriver(), dto.getHomepageTitle());
	}
}
