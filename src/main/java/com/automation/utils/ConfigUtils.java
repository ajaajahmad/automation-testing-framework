package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

	private static Properties properties;
	private static final String CONFIG_FILE_PATH = "src/test/resources/config.properties";

	static {
		loadProperties();
	}

	private static void loadProperties() {
		try {
			properties = new Properties();

			InputStream inputStream = ConfigUtils.class.getClassLoader().getResourceAsStream("config.properties");

			if (inputStream != null) {
				properties.load(inputStream);
				System.out.println("Properties loaded from class path");
			} else {
				FileInputStream fileInput = new FileInputStream(CONFIG_FILE_PATH);
				properties.load(fileInput);
				System.out.println("Properties loaded from file path");
				fileInput.close();
			}
		} catch (IOException e) {
			System.out.println("❌ Failed to load properties file: " + e.getMessage());
			throw new RuntimeException("Cannot load configuration properties", e);
		}

	}
}
