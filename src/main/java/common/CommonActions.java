package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import constants.Attribute;
import reports.Loggers;

public class CommonActions {

	public static void input(WebElement element, String inputValue) {
		try {
			element.sendKeys(inputValue);
			Loggers.log(element + "---> Input value: " + inputValue);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());
		}
	}

	public static void click(WebElement element) {
		try {
			element.click();
			Loggers.log(element + "---> Clicked ");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());
		}
	}

	public static void verifyText(WebElement element, String expected) {
		String actual = element.getText();
		Loggers.log(element + " ---> Actula text : " + actual + ". Expected text : " + expected);
		Assert.assertEquals(actual, expected);
	}
	
	public static void verifyText(String text1, String text2) {
		Loggers.log(text1 + " ---> Comparing with : ---> " + text2);
		Assert.assertEquals(text1, text2);
	}

	public static void verifyAttribute(WebElement element, String expected, Attribute attribute) {
		String actual = getAttributeValue(element, attribute);
		// element.getAttribute(attribute.toString());
		Loggers.log(element + " ---> Actula text : " + actual + ". Expected text : " + expected);
		Assert.assertEquals(actual, expected);
	}

	public static String getAttributeValue(WebElement element, Attribute attribute) {
		return element.getAttribute(attribute.toString());
	}

	public static void clear(WebElement element) {
		try {
			element.clear();
			Loggers.log(element + " ---> cleared");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());
		}
	}
	
	public static void verifyTitle(WebDriver driver,String expectedTitle) {
		Loggers.log("Actual Title is : " + driver.getTitle() + "---> And Expected Title is :" + expectedTitle);
		Assert.assertEquals(driver.getTitle(), expectedTitle);
	}
}
