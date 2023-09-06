package utils;

import java.io.IOException;
import java.util.Properties;

import constants.KeyConfig;

public class ReadConfig {

	Properties properties;

	public ReadConfig() {
		loadProperties();
	}

	private void loadProperties() {
		properties = new Properties();
		try {
			properties.load(getClass().getClassLoader().getResourceAsStream("configuration.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getValue(KeyConfig key) {
		return properties.getProperty(key.toString());
	}
}
