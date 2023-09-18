package quote.auto;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.TestBase;

public class AutoQuoteTest extends TestBase{

	@Test(groups = {"regression", "auto", "smoke"})
	public void getAutoQuoteTest() {
		homePage.verifyTitleText("Welcome to AAA Northeast");
		homePage.verifySubTitleText("To ensure you receive the best service possible,<br>please enter your zip code below:");
		homePage.verifyFooterText("AAA Northeast&nbsp; serves members in CT, MA, NH, NJ, NY &amp; RI.");
		homePage.clickSubmitBtn();
		homePage.verifyErrorMsgText("Please enter a valid ZIP code so we can direct you to the<br>AAA website in your area.");
		homePage.inputZipCodeField("abcd");
		homePage.verifyLength("5");
		homePage.clickSubmitBtn();
		homePage.verifyErrorMsgText("Please enter a valid ZIP code so we can direct you to the<br>AAA website in your area.");
		homePage.clearZipCodeField();
		homePage.inputZipCodeField("1a2b3");
		homePage.clickSubmitBtn();
		homePage.verifyErrorMsgText("Please enter a valid ZIP code so we can direct you to the<br>AAA website in your area.");
		homePage.clearZipCodeField();
		homePage.inputZipCodeField("11418");
		homePage.clickSubmitBtn();
		homePage.verifyHomePageTitleText(getDriver(),"Home | AAA Northeast");
		homePage.validateMenuList();
		homePage.hoverOnMembership(getDriver());
		homePage.readSubMenuOfMemebrship();
		homePage.verifyMembershipFooterText("Join:(800) JOIN-AAA (800-564-6222)");
		homePage.clickHomeInsurance(getDriver());
	}
	
	@Test(groups = {"regression", "auto"})
	public void submitBtnAutoTest() {
		homePage.verifyTitleText("Welcome to AAA Northeast");
		homePage.verifySubTitleText("To ensure you receive the best service possible,<br>please enter your zip code below:");
		homePage.verifyFooterText("AAA Northeast&nbsp; serves members in CT, MA, NH, NJ, NY &amp; RI.");
		homePage.clickSubmitBtn();
		Assert.fail();
	}
}
