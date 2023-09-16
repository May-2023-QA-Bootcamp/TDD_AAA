package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import constants.Attribute;
import constants.IFileLocator;
import utils.ReadFile;
import static common.CommonActions.*;
import java.util.ArrayList;
import java.util.List;

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
	@FindBy(xpath = "//div[contains(@class,'navbar-collapse')]/ul[contains(@class,'aaa-header-tabs')]/li")
	List<WebElement> menuList;
	@FindBy(xpath = "(//div[contains(@class,'navbar-collapse')]/ul[contains(@class,'aaa-header-tabs')]/li)[2]/ul/li/span")
	List<WebElement> membershipSubMenuList;
	@FindBy(xpath = "//li[@id='nav-insurance-col2']/ul/li/a[text()='Home & Condo Insurance']")
	WebElement homeNCondoBtn;
	@FindBy(xpath = "//li[@id='nav-membership-parent']/child::ul/child::div")
	WebElement membershipFooterText;
	
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
	
	public void validateMenuList() {
		ReadFile file = new ReadFile(IFileLocator.MENU);
		List<String> list = file.getList();
		List<String> menuListText = new ArrayList<>();
		for(WebElement e: menuList) {
			String menu = e.getText();
			if(menu.contains("NOW OPEN") && menu.contains("DMV Services")) {
				menu = "NOW OPEN DMV Services";
			}
			menuListText.add(menu);
		}
		verifyText(list, menuListText);
		file.closeResource();
	}
	
	public void hoverOnMembership(WebDriver driver) {
		sleep(1);
		hoverOverOnly(driver, menuList.get(1));
	}
	
	public void readSubMenuOfMemebrship() {
		ReadFile file = new ReadFile(IFileLocator.MEMBERSHIP_CATEGORY);
		List<String> expectedMembershipCategoryList = file.getList();
		List<String> actualMembershipCategoryListText = new ArrayList<>();
		sleep(1);
		for(WebElement e: membershipSubMenuList) {
			actualMembershipCategoryListText.add(e.getText());
		}
		verifyText(expectedMembershipCategoryList, actualMembershipCategoryListText);
		file.closeResource();
	}
	
	public void verifyMembershipFooterText(String expected) {
		verifyText(membershipFooterText, expected);
	}
	
	public void clickHomeInsurance(WebDriver driver) {
		sleep(1);
		hoverOverOnly(driver, menuList.get(3));
		sleep(1);
		hoverOverTo(driver, menuList.get(3), homeNCondoBtn);
		sleep(1);
	}
}
