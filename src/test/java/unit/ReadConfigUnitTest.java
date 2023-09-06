package unit;

import org.testng.annotations.Test;

import constants.KeyConfig;
import utils.ReadConfig;

public class ReadConfigUnitTest {

	@Test(enabled = false)
	public void getPropertiesTest() {
		ReadConfig config = new ReadConfig();
		String urlString = config.getValue(KeyConfig.explicitWaitLoad);
		System.out.println(urlString.getClass().getName());
		Integer number = Integer.parseInt(urlString);
		System.out.println(number);
	}
	
}
