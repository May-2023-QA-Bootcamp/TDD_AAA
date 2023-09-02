package liberty.mutual.insurance.unit;

import org.testng.annotations.Test;

import liberty.mutual.insurance.constants.KeyConfig;
import liberty.mutual.insurance.utils.ReadConfig;

public class ReadConfigUnitTest {

	@Test
	public void getPropertiesTest() {
		ReadConfig config = new ReadConfig();
		String urlString = config.getValue(KeyConfig.explicitWaitLoad);
		System.out.println(urlString.getClass().getName());
		Integer number = Integer.parseInt(urlString);
		System.out.println(number);
	}
	
}
