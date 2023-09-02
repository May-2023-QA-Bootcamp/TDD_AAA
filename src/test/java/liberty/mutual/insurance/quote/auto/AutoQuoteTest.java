package liberty.mutual.insurance.quote.auto;

import org.testng.annotations.Test;

import liberty.mutual.insurance.base.TestBase;

public class AutoQuoteTest extends TestBase{

	@Test
	public void getAutoQuoteTest() {
		homePage.inputZipCode("11423");
		homePage.clickGetMyPrice();
	}
}
