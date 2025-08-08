package com.automation.base;

import com.automation.utils.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Duration;

// Base class for all page objects Contains common methods and WebDriver initialization
public abstract class BasePage {
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected WaitHelper waitHelper;
	protected static final Logger logger = LogManager.getLogger(BasePage.class);

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.waitHelper = new WaitHelper(driver);
		PageFactory.initElements(driver, this);
		logger.info("Initialized page: " + this.getClass().getSimpleName());
	}

	// Get page title
	public String getPageTitle() {
		return driver.getTitle();
	}

	// Get current URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	// Click element with wait
	protected void clickElement(WebElement element) {
		waitHelper.waitForElementToBeClickable(element);
		element.click();
		logger.info("Clicked element: " + element.toString());
	}

	// Send text to element with wait
	protected void sendText(WebElement element, String text) {
		waitHelper.waitForElementToBeVisible(element);
		element.clear();
		element.sendKeys(text);
		logger.info("Entered text '" + text + "' into element: " + element.toString());
	}

	// Get text from element with wait
	protected String getText(WebElement element) {
		waitHelper.waitForElementToBeVisible(element);
		String text = element.getText();
		logger.info("Retrieved text '" + text + "' from element: " + element.toString());
		return text;
	}

	// Check if element is displayed
	protected boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}