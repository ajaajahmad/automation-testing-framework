package com.automation.tests;

import com.automation.base.BaseTest;
import com.automation.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

// Login functionality test cases
public class LoginTest extends BaseTest {

	@Test(priority = 1, description = "Verify successful login with valid credentials")
	public void testValidLogin() {
		LoginPage loginPage = new LoginPage(driver);

		// Verify login page is loaded
		Assert.assertTrue(loginPage.isLoginPageLoaded(), "Login page is not loaded");

		// Perform login
		loginPage.login("testuser", "testpassword");

		// Add assertions for successful login
		// Assert.assertTrue(homePage.isUserLoggedIn(), "User is not logged in");

		logger.info("Valid login test completed successfully");
	}

	@Test(priority = 2, description = "Verify login with invalid credentials")
	public void testInvalidLogin() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login("invaliduser", "invalidpassword");

		// Verify error message is displayed
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed");
		Assert.assertEquals(loginPage.getErrorMessage(), "Invalid credentials", "Error message text is incorrect");

		logger.info("Invalid login test completed successfully");
	}

	@Test(priority = 3, description = "Verify login with empty credentials")
	public void testEmptyCredentialsLogin() {
		LoginPage loginPage = new LoginPage(driver);

		loginPage.login("", "");

		// Verify appropriate validation message
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Validation message is not displayed");

		logger.info("Empty credentials login test completed successfully");
	}
}