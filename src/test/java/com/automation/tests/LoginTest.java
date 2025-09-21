package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.utils.AuthUtils;

public class LoginTest extends BaseTest {

	@Test
	public void validLoginTest() {
		// Check if login page is displayed
		Assert.assertTrue(AuthUtils.isLoginPageDisplayed(driver), "Login page is not displayed");

		// Login using AuthUtils
		boolean loginSuccess = AuthUtils.login(driver);
		Assert.assertTrue(loginSuccess, "Login should be successful");

		System.out.println("Valid login test passed successfully");
	}

	@Test
	public void loginWithCustomCredentialsTest() {
		Assert.assertTrue(AuthUtils.isLoginPageDisplayed(driver), "Login page is not displayed");

		// Login with custom credentials
		boolean loginSuccess = AuthUtils.login(driver, "custom_user", "custom_pass");
		System.out.println("Custom login test result: " + loginSuccess);
	}

	@Test
	public void completeLoginLogoutFlowTest() {
		// Verify we're on login page
		Assert.assertTrue(AuthUtils.isLoginPageDisplayed(driver), "Should start on login page");

		// Login
		boolean loginSuccess = AuthUtils.login(driver);
		Assert.assertTrue(loginSuccess, "Login should be successful");
		Assert.assertTrue(AuthUtils.isLoggedIn(driver), "Should be logged in");

		// Logout
		boolean logoutSuccess = AuthUtils.logout(driver);
		Assert.assertTrue(logoutSuccess, "Logout should be successful");
		Assert.assertTrue(AuthUtils.isLoggedOut(driver), "Should be logged out");

		System.out.println("Complete login-logout flow test passed successfully");
	}

	@Test(enabled = false)
	public void invalidLoginTest() {
		System.out.println("Invalid login test - disabled for now");
	}
}