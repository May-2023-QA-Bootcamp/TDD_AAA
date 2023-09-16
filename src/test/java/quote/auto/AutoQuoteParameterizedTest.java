package quote.auto;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import base.TestBase;
import static constants.IParams.*;

public class AutoQuoteParameterizedTest extends TestBase{

	@Test
	@Parameters({TITLE, INVALID_ZIP_1, ZIP_LENGTH, INVALID_ZIP_2, ZIP_CODE, HOME_PAGE_TITLE, MEMBERSHIP_FOOTER})
	public void getAutoQuoteTest(String title, String invalidZip1, String zipLen,
			String invalidZip2, String zipCode, String homeTitle, String membershipFooter) {
		homePage.verifyTitleText(title);
		homePage.clickSubmitBtn();
		homePage.inputZipCodeField(invalidZip1);
		homePage.verifyLength(zipLen);
		homePage.clickSubmitBtn();
		homePage.clearZipCodeField();
		homePage.inputZipCodeField(invalidZip2);
		homePage.clickSubmitBtn();
		homePage.clearZipCodeField();
		homePage.inputZipCodeField(zipCode);
		homePage.clickSubmitBtn();
		homePage.verifyHomePageTitleText(getDriver(),homeTitle);
		homePage.validateMenuList();
		homePage.hoverOnMembership(getDriver());
		homePage.readSubMenuOfMemebrship();
		homePage.verifyMembershipFooterText(membershipFooter);
		homePage.clickHomeInsurance(getDriver());
	}
}
