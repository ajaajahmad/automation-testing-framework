package com.automation.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.automation.utils.AuthUtils;
import com.automation.utils.ConfigUtils;

public class BaseTest {

	protected WebDriver driver;

	@BeforeSuite
	public void setUp() {
		try {

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigUtils.getImplicitTimeout()));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(ConfigUtils.getPageTimeout()));

			String loginUrl = ConfigUtils.getLoginUrl();
			System.out.println("Navigating to: " + loginUrl);
			driver.get(loginUrl);

		} catch (Exception e) {
			System.out.println("Setup failed: " + e.getMessage());
			e.printStackTrace();
			throw e;
		}
	}

	@BeforeMethod
	public void beforeEachTest() {
		try {

			if (!AuthUtils.isLoggedOut(driver)) {
				System.out.println("User is logged in, logging out first...");
				AuthUtils.logout(driver);
			}

			if (!driver.getCurrentUrl().contains("/auth/login")) {
				driver.get(ConfigUtils.getLoginUrl());
			}

		} catch (Exception e) {
			System.out.println("Before test setup failed: " + e.getMessage());
		}
	}

	@AfterMethod
	public void cleanupAfterTest() {
		try {

			if (AuthUtils.isLoggedIn(driver)) {
				System.out.println("Logging out after test...");
				AuthUtils.logout(driver);
			}

		} catch (Exception e) {
			System.out.println("Test cleanup failed: " + e.getMessage());
		}
	}

	@AfterSuite
	public void tearDown() {
		try {

			if (driver != null) {
				if (AuthUtils.isLoggedIn(driver)) {
					AuthUtils.logout(driver);
				}

				System.out.println("Closing browser...");
				driver.quit();
				System.out.println("Browser closed successfully");
			}

		} catch (Exception e) {
			System.out.println("Final cleanup error: " + e.getMessage());
			if (driver != null) {
				driver.quit();
			}
		}
	}
}