package common;

import org.openqa.selenium.NoSuchElementException;
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
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());
		}
	}
	
	public static void click(WebElement element) {
		try {
			element.click();
			Loggers.log(element + "---> Clicked ");
		} catch (NoSuchElementException e) {
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());
		}
	}
	
	public static void verifyText(WebElement element, String expected) {
		String actual = element.getText();
		Loggers.log(element + " ---> Actula text : " + actual + ". Expected text : " + expected);
		Assert.assertEquals(actual, expected);
	}
	
	public static void verifyAttribute(WebElement element, String expected, Attribute attribute) {
		String actual = getAttributeValue(element, attribute);
				//element.getAttribute(attribute.toString());
		Loggers.log(element + " ---> Actula text : " + actual + ". Expected text : " + expected);
		Assert.assertEquals(actual, expected);
	}
	
	private static String getAttributeValue(WebElement element, Attribute attribute) {
		return element.getAttribute(attribute.toString());
	}
}
