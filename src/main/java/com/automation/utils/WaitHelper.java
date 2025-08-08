package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
	private WebDriver driver;
	private WebDriverWait wait;
	private static final int DEFAULT_TIMEOUT = 30;

	public WaitHelper(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
	}

	// Wait for element to be visible
	public void waitForElementToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	// Wait for element to be clickable
	public void waitForElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	// Wait for page title to contain text
	public void waitForTitleContains(String title) {
		wait.until(ExpectedConditions.titleContains(title));
	}

	// Wait for URL to contain text
	public void waitForUrlContains(String url) {
		wait.until(ExpectedConditions.urlContains(url));
	}

	public void waitForPageLoad() {
		wait.until(webDriver -> ((JavascriptExecutor) this.driver).executeScript("return document.readyState")
				.equals("complete"));
	}

	public void staticWait(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}