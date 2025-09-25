package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthUtils {

	protected WebDriver driver;

	@FindBy(xpath = "//input[@formcontrolname='username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement passWord;
	@FindBy(css = "button[class='submit']")
	private WebElement loginButton;
	@FindBy(css = "span[class='user-name-alias']")
	private WebElement userProfile;
	@FindBy(css = "a[class='dropdown-item']")
	private WebElement logOutButton;

	private AuthUtils(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static boolean login(WebDriver driver) {
		String username = ConfigUtils.getUsername();
		String password = ConfigUtils.getPassword();
		return login(driver, username, password);
	}

	public static boolean login(WebDriver driver, String username, String password) {
		try {
			System.out.println("Attempting login with username: " + username);

			AuthUtils auth = new AuthUtils(driver);

			if (!driver.getCurrentUrl().contains("/auth/login")) {
				driver.get(ConfigUtils.getLoginUrl());
			}

			auth.userLogin(username, password);

			boolean loginSuccess = !driver.getCurrentUrl().contains("/auth/login");

			if (loginSuccess) {
				System.out.println("Login successful!");
			} else {
				System.out.println("Login failed - still on login page");
			}

			return loginSuccess;

		} catch (Exception e) {
			System.out.println("Login error: " + e.getMessage());
			return false;
		}
	}

	public static void logout(WebDriver driver) {
		try {
			System.out.println("Attempting logout...");

			if (driver.getCurrentUrl().contains("/auth/login")) {
				System.out.println("User is already logged out");
			}

			AuthUtils auth = new AuthUtils(driver);

			boolean logoutSuccess = auth.userLogout();

			if (logoutSuccess) {
				System.out.println("Logout successful!");
			} else {
				System.out.println("Logout failed");
			}

		} catch (Exception e) {
			System.out.println("Logout error: " + e.getMessage());
		}
	}

	public static boolean isLoginPageDisplayed(WebDriver driver) {
		try {
			AuthUtils auth = new AuthUtils(driver);
			return auth.isLoginPageDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isLoggedIn(WebDriver driver) {
		return !driver.getCurrentUrl().contains("/auth/login");
	}

	public static boolean isLoggedOut(WebDriver driver) {
		return driver.getCurrentUrl().contains("/auth/login");
	}

	private void enterUsername(String username) {
		try {
			userName.clear();
			userName.sendKeys(username);
			System.out.println("Username entered");
		} catch (Exception e) {
			System.out.println("Failed to enter username: " + e.getMessage());
			throw e;
		}
	}

	private void enterPassword(String password) {
		try {
			passWord.clear();
			passWord.sendKeys(password);
			System.out.println("Password entered");
		} catch (Exception e) {
			System.out.println("Failed to enter password: " + e.getMessage());
			throw e;
		}
	}

	private void clickLoginButton() {
		try {
			loginButton.click();
			System.out.println("Login button clicked");
		} catch (Exception e) {
			System.out.println("Failed to click login button: " + e.getMessage());
			throw e;
		}
	}

	private void userLogin(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}

	private boolean isLoginPageDisplayed() {
		try {
			return userName.isDisplayed() && passWord.isDisplayed() && loginButton.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	private void clickUserProfile() {
		try {
			userProfile.click();
			System.out.println("User profile clicked");
		} catch (Exception e) {
			System.out.println("Failed to click user profile: " + e.getMessage());
			throw e;
		}
	}

	private void clickLogout() {
		try {
			logOutButton.click();
			System.out.println("Logout button clicked");
		} catch (Exception e) {
			System.out.println("Failed to click logout button: " + e.getMessage());
			throw e;
		}
	}

	private boolean userLogout() {
		try {
			clickUserProfile();
			clickLogout();

			return isLoginPageDisplayed();

		} catch (Exception e) {
			System.out.println("Logout process failed: " + e.getMessage());
			return false;
		}
	}
}