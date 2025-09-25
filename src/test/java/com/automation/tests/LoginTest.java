package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.base.BaseTest;
import com.automation.utils.AuthUtils;
import com.automation.utils.ConfigUtils;

public class LoginTest extends BaseTest {

	@Test(priority = 1)
	public void verifyLoginPageDisplayed() {

		boolean isLoginPageDisplayed = AuthUtils.isLoginPageDisplayed(driver);
		Assert.assertTrue(isLoginPageDisplayed, "Login page should be displayed with all elements");

		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("/auth/login"), "Should be on login page URL");

		System.out.println("Login page verification test passed");
	}

	@Test(priority = 2)
	public void validLoginTest() {

		Assert.assertTrue(AuthUtils.isLoginPageDisplayed(driver), "Should start on login page");
		Assert.assertTrue(AuthUtils.isLoggedOut(driver), "Should be logged out initially");

		boolean loginSuccess = AuthUtils.login(driver);
		Assert.assertTrue(loginSuccess, "Login with valid credentials should be successful");

		Assert.assertTrue(AuthUtils.isLoggedIn(driver), "Should be logged in after successful login");
		Assert.assertFalse(driver.getCurrentUrl().contains("/auth/login"), "Should be redirected from login page");

		System.out.println("Valid login test passed successfully");
	}

	@Test(priority = 3)
	public void completeLoginLogoutFlowTest() {

		Assert.assertTrue(AuthUtils.isLoginPageDisplayed(driver), "Should start on login page");
		Assert.assertTrue(AuthUtils.isLoggedOut(driver), "Should be logged out initially");

		boolean loginSuccess = AuthUtils.login(driver);
		Assert.assertTrue(loginSuccess, "Login should be successful");
		Assert.assertTrue(AuthUtils.isLoggedIn(driver), "Should be logged in after login");

		AuthUtils.logout(driver);

		Assert.assertTrue(AuthUtils.isLoggedOut(driver), "Should be logged out after logout");
		Assert.assertTrue(AuthUtils.isLoginPageDisplayed(driver), "Should be back on login page");

		System.out.println("Complete login-logout flow test passed successfully");
	}

	@Test(priority = 4)
	public void multipleLoginAttemptsTest() {

		boolean firstLogin = AuthUtils.login(driver);
		Assert.assertTrue(firstLogin, "First login should be successful");

		AuthUtils.logout(driver);
		Assert.assertTrue(AuthUtils.isLoggedOut(driver), "Should be logged out");

		boolean secondLogin = AuthUtils.login(driver);
		Assert.assertTrue(secondLogin, "Second login should also be successful");

		System.out.println("Multiple login attempts test passed successfully");
	}

	@Test(priority = 5)
	public void verifyConfigurationTest() {

		String username = ConfigUtils.getUsername();
		String loginUrl = ConfigUtils.getLoginUrl();

		Assert.assertNotNull(username, "Username should be loaded from config");
		Assert.assertNotNull(loginUrl, "Login URL should be loaded from config");
		Assert.assertFalse(username.isEmpty(), "Username should not be empty");
		Assert.assertFalse(loginUrl.isEmpty(), "Login URL should not be empty");

		System.out.println("Configuration loaded successfully:");
		System.out.println("Configuration verification test passed");
	}

	@Test(priority = 6, enabled = false)
	public void invalidLoginTest() {

		boolean loginResult = AuthUtils.login(driver, "invalid_user", "invalid_password");
		Assert.assertFalse(loginResult, "Login with invalid credentials should fail");
		Assert.assertTrue(AuthUtils.isLoggedOut(driver), "Should remain logged out");

		System.out.println("Invalid login test passed");
	}
}