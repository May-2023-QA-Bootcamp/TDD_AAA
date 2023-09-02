package liberty.mutual.insurance.unit;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import liberty.mutual.insurance.base.TestBase;

public class SvgTest extends TestBase{

	//@Test
	public void getAllSvg() {
		List<WebElement> elements = driver.findElements(By.xpath("//*[name()='svg']/*[name()='rect']/*[name()='title']"));
		elements.stream().forEach(e -> System.out.println(e.getAttribute("innerHTML")));
		WebElement element = driver.findElement(By.xpath("(//*[name()='svg']/*[name()='rect']/*[name()='title'])[1]"));
		System.out.println("InnerHTML : " + element.getAttribute("innerHTML"));
	}
	
	@Test
	public void testBestBuy() throws InterruptedException {
		driver.get("https://www.bestbuy.com/");
		Thread.sleep(2000);
		System.out.println("--------"+driver.getTitle());
		//driver.switchTo().alert().dismiss();
		driver.findElement(By.id("gh-search-input")).sendKeys("iphone 14");
		driver.findElement(By.className("header-search-button")).click();
		
	}
}