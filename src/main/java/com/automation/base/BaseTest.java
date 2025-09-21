package com.automation.base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
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
			driver.get(ConfigUtils.getLoginUrl());

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@AfterSuite
	public void tearDown() {
		try {
			if (driver != null) {
				AuthUtils.logout(driver);
				driver.quit();
				System.out.println("Browser closed successfully");
			}
		} catch (Exception e) {
			System.out.println("Cleanup error: " + e.getMessage());
			if (driver != null) {
				driver.quit();
			}
		}
	}
}