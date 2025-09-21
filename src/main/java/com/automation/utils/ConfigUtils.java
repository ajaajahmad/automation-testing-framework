package com.automation.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

	private static Properties properties;

	static {
		loadProperties();
	}

	private static void loadProperties() {
		try {
			properties = new Properties();
			InputStream inputStream = ConfigUtils.class.getClassLoader().getResourceAsStream("config.properties");
			properties.load(inputStream);
			inputStream.close();
		} catch (Exception e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static String getLoginUrl() {
		return getProperty("app.login.url");
	}

	public static String getUsername() {
		return getProperty("login.username");
	}

	public static String getPassword() {
		return getProperty("login.password");
	}

	public static int getImplicitTimeout() {
		return Integer.parseInt(getProperty("browser.timeout.implicit"));
	}

	public static int getPageTimeout() {
		return Integer.parseInt(getProperty("browser.timeout.page"));
	}
}