package quote.auto;

import org.testng.annotations.Test;
import base.TestBase;

public class AutoQuoteTest extends TestBase{

	@Test
	public void getAutoQuoteTest() {
		homePage.verifyTitleText(null);
		homePage.verifySubTitleText(null);
		homePage.verifyFooterText(null);
		//homePage.inputZipCode("11423");
		//homePage.clickSubmitBtn();
	}
}
