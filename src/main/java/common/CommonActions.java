package common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import com.google.common.io.Files;
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
			Assert.fail();
		}
	}

	public static void click(WebElement element) {
		try {
			element.click();
			Loggers.log(element + "---> Clicked ");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());
			Assert.fail();
		}
	}

	public static void verifyText(WebElement element, String expected) {
		String actual = element.getText();
		Loggers.log(element + " ---> Actula text : " + actual + ". Expected text : " + expected);
		Assert.assertEquals(actual, expected);
	}

	public static void verifyText(Object obj1, Object obj2) {
		Loggers.log(obj1 + " ---> Comparing with : ---> " + obj2);
		Assert.assertEquals(obj1, obj2);
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
			Assert.fail();
		}
	}

	public static void verifyTitle(WebDriver driver, String expectedTitle) {
		try {
			Loggers.log("Actual Title is : " + driver.getTitle() + "---> And Expected Title is :" + expectedTitle);
			Assert.assertEquals(driver.getTitle(), expectedTitle);
		} catch (NullPointerException e) {
			e.printStackTrace();
			Loggers.log("driver is not initiated properly");
			Assert.fail();
		}
	}

	public static void hoverOverOnly(WebDriver driver, WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).build().perform();
			Loggers.log("Hovering on ---> " + element);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(element + " ---> Not Found \n" + e.getMessage());
			Assert.fail();
		}
	}

	public static void hoverOverTo(WebDriver driver, WebElement src_element, WebElement target_element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(src_element).click(target_element).build().perform();
			Loggers.log("Hovering on ---> " + src_element);
			Loggers.log("Clicking on ---> " + target_element);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Loggers.log(src_element + " || " + target_element + " ---> Not Found \n" + e.getMessage());
			Assert.fail();
		}
	}

	public static void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getSreenShot(String testName, WebDriver driver) {
		TakesScreenshot ss = (TakesScreenshot) driver;
		String path = System.getProperty("user.dir") + "/test-output/screenShots";
		File folder = new File(path);
		if (!folder.exists()) {
			folder.mkdirs();
		}
		
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy_hh.mm.ss");
		String formattedDate = dateFormat.format(date);
		
		File targetFile = new File(path + "/error_" + testName + "_" + formattedDate + ".png");
		try {
			File srcFile = ss.getScreenshotAs(OutputType.FILE);
			Files.copy(srcFile, targetFile);
			Loggers.log("Screenshot has been successfully capture at: \n" + targetFile.getAbsolutePath());
		} catch (WebDriverException | IOException e) {
			e.printStackTrace();
			Loggers.log("Screenshot cannot capture");
		}
		return targetFile.getAbsolutePath();
	}
}
