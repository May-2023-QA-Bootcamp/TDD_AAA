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
	
	@FindBy(xpath = "//div[@class='zipcodeTitle']/div[contains(@class,'b6')]")
	WebElement titleText;
	@FindBy(xpath = "//div[@class='zipcodeMid']/div[contains(@class,'dkg6')]")
	WebElement subTitleText;
	@FindBy(xpath = "(//div[@class='zipcodeBottomText']/span)[1]")
	WebElement footerText1;
	@FindBy(xpath = "(//div[@class='zipcodeBottomText']/span)[2]")
	WebElement footerText2;
	@FindBy(id = "zipcodeInput")
	WebElement zipCodeField;
	@FindBy(id = "zipcodeSubmit")
	WebElement submitBtn;
	@FindBy(xpath = "//div[@class='zipcodeMid']/descendant::div[contains(@class,'r6')]")
	WebElement errorMsgText;

	public void verifyTitleText(String expectedString) {
		//verifyText(titleText, expectedString);
		verifyAttribute(titleText, expectedString, Attribute.INNER_HTML);
	}
	
	public void verifySubTitleText(String expectedString) {
		//verifyText(subTitleText, expectedString);
		verifyAttribute(subTitleText, expectedString, Attribute.INNER_HTML);
	}
	
	public void verifyFooterText(String expectedString) {
		//verifyText(footerText, expectedString);
		String footerText = getAttributeValue(footerText1, Attribute.INNER_HTML) + " "+
				getAttributeValue(footerText2, Attribute.INNER_HTML);
		verifyText(footerText, expectedString);
	}
	
	public void clickSubmitBtn() {
		click(submitBtn);
	}
	
	public void verifyErrorMsgText(String expectedString) {
		//verifyText(errorMsgText, expectedString);
		verifyAttribute(errorMsgText, expectedString, Attribute.INNER_HTML);
	}
	
	public void inputZipCodeField(String zipCode) {
		input(zipCodeField, zipCode);
	}
	
	public void verifyLength(String expected) {
		verifyAttribute(zipCodeField, expected, Attribute.MAX_LENGTH);
	}
	
	public void clearZipCodeField() {
		clear(zipCodeField);
	}
	
	public void verifyHomePageTitleText(WebDriver driver,String expectedTitle) {
		verifyTitle(driver, expectedTitle);
	}
}
