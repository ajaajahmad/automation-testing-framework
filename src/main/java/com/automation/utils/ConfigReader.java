package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	private static final String PROPERTY_FILE_PATH = "src/main/resources/config.properties";

	private void ConfigReader() {
	}

	public static void loadConfig() {
		try {
			properties = new Properties();
			FileInputStream inputStream = new FileInputStream(PROPERTY_FILE_PATH);
			properties.load(inputStream);
			inputStream.close();
		} catch (IOException e) {
			throw new RuntimeException("Failed to load properties file: " + e.getMessage());
		}
	}

	public static String getProperty(String key) {
		if (properties == null) {
			loadConfig();
		}
		String value = properties.getProperty(key);
		if (value == null) {
			throw new RuntimeException("Property " + key + " not found in config file");
		}
		return value;
	}
}