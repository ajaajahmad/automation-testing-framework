package com.automation.utils;

import org.openqa.selenium.WebDriver;

import com.automation.pages.LoginPage;

public class AuthUtils {

	public static boolean login(WebDriver driver) {
		String username = ConfigUtils.getUsername();
		String password = ConfigUtils.getPassword();
		return login(driver, username, password);
	}

	public static boolean login(WebDriver driver, String username, String password) {
		try {
			LoginPage loginPage = new LoginPage(driver);

			if (!loginPage.isLoginPageDisplayed()) {
				driver.get(ConfigUtils.getLoginUrl());
			}

			loginPage.userLogin(username, password);

			boolean loginSuccess = !driver.getCurrentUrl().contains("/auth/login");

			if (loginSuccess) {
				System.out.println("Login successful");
			} else {
				System.out.println("Login failed");
			}

			return loginSuccess;
		} catch (Exception e) {
			System.out.println("Login error: " + e.getMessage());
			return false;
		}
	}
}
