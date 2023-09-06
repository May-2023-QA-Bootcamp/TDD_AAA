package unit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {

	@Test
	public void testhardAssert() {
		Assert.assertEquals("Name", "Names");
		System.out.println("After Hard Assert");
	}
	
	@Test
	public void softAssert() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(false, true);
		softAssert.assertEquals("Karim", "Not Karim");
		softAssert.assertEquals(2, 3);
		softAssert.assertEquals(false, false);
		System.out.println("After soft assert");
		// Below method need to add at the end of any test to reflect failed steps
		softAssert.assertAll();
	}
}
