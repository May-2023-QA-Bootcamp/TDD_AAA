package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

import reports.Loggers;

public class TestNGAttributesTest {

	@Test(enabled = true, groups = {"auto","smoke","regression"} , dependsOnMethods = "test2", ignoreMissingDependencies = true)
	public void test1() {
		//HomePage.validateTitle()
		//HomePage.validateSubTitle()
		Loggers.log("This is a Test 1");
	}
	
	@Test(enabled = false, groups = {"smoke","regression"})
	public void test2() {
		Loggers.log("This is a Test 2");
	}
	
	@Test(enabled = true, groups = "regression", dependsOnMethods = "test4", alwaysRun = true)
	public void test3() {
		Loggers.log("This is a Test 3");
	}
	
	@Test(enabled = true, groups = "smoke")
	public void test4() {
		Loggers.log("This is a Test 4");
		Assert.fail();
	}
}
