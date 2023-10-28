package unit;

import static constants.BS_Key.*;

import org.testng.annotations.Test;

import constants.KeyConfig;
import constants.Profile;
import utils.ReadConfig;

public class ReadConfigUnitTest {

	@Test(enabled = false)
	public void getPropertiesTest() {
		ReadConfig config = new ReadConfig(Profile.GENERAL);
		String urlString = config.getValue(KeyConfig.explicitWaitLoad);
		System.out.println(urlString.getClass().getName());
		Integer number = Integer.parseInt(urlString);
		System.out.println(number);
	}
	
	@Test
	public void readConfigBS() {
		ReadConfig bsConfig = new ReadConfig(Profile.BROWSERSTACK);
		String urlString = "https://" + bsConfig.getValue(BS_USER) + ":" + bsConfig.getValue(BS_ACCESS) + 
				bsConfig.getValue(BS_URL);
		System.out.println(urlString);
	}
}
