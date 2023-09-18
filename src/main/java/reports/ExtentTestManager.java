package reports;

import java.util.HashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	static HashMap<Long, ExtentTest> tests = new HashMap<>();
	
	public static ExtentTest createTest(ExtentReports report, String testName){
		ExtentTest test = report.createTest(testName);
		tests.put(Thread.currentThread().getId(), test);
		return test;
	}
	
	public static ExtentTest getTest(){
		return tests.get(Thread.currentThread().getId());
	}
}
