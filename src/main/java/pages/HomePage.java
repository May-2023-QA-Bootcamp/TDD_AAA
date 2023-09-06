package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Attribute;

import static common.CommonActions.*;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy()
	WebElement titleText;
	@FindBy()
	WebElement subTitleText;
	@FindBy()
	WebElement footerText;
	@FindBy()
	WebElement zipCodeField;
	@FindBy()
	WebElement submitBtn;
	@FindBy()
	WebElement errorMsgText;
	@FindBy()
	WebElement homePageTitleText;

	public void verifyTitleText(String expectedString) {
		verifyText(titleText, expectedString);
	}
	
	public void verifySubTitleText(String expectedString) {
		verifyText(subTitleText, expectedString);
	}
	
	public void verifyFooterText(String expectedString) {
		verifyText(footerText, expectedString);
	}
	
	public void clickSubmitBtn() {
		click(submitBtn);
	}
	
	public void verifyErrorMsgText(String expectedString) {
		verifyText(errorMsgText, expectedString);
	}
	
	public void inputZipCodeField(String zipCode) {
		input(zipCodeField, zipCode);
	}
	
	public void verifyLength(String expected) {
		verifyAttribute(zipCodeField, expected, Attribute.MAX_LENGTH);
	}
}
