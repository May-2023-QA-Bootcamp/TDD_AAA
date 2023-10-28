package utils;

import java.io.IOException;
import java.util.Properties;

import constants.BS_Key;
import constants.KeyConfig;
import constants.Profile;

public class ReadConfig {

	Properties properties;
	
	String generalConfig = "configuration.properties";
	String browserStackConfig = "browserstack.properties";

	public ReadConfig(Profile profile) {
		switch (profile) {
		case GENERAL:
			loadProperties(generalConfig);
			break;
		case BROWSERSTACK:
			loadProperties(browserStackConfig);
			break;
		default:
			break;
		}
	}

	private void loadProperties(String profile) {
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream(profile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(KeyConfig key) {
		return properties.getProperty(key.toString());
	}
	
	public String getValue(BS_Key key) {
		return properties.getProperty(key.toString());
	}
}
