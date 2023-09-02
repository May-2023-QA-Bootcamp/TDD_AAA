package liberty.mutual.insurance.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static liberty.mutual.insurance.common.CommonActions.*;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "quote-zipCode-input")
	WebElement zipCodeField;
	@FindBy(xpath = "//button[contains(.,'Get my price')]")
	WebElement getMyPriceBtn;
	
	public void inputZipCode(String zipCode) {
		input(zipCodeField, zipCode);
	}
	
	public void clickGetMyPrice() {
		click(getMyPriceBtn);
	}
}
