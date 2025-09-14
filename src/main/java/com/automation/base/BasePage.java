package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.ConfigReader;
import com.automation.utils.Logger;
import com.automation.utils.WaitHelper;

public class BasePage {

	@FindBy(id = "username")
	protected WebElement Username;
	@FindBy(id = "password")
	protected WebElement Password;
	@FindBy(id = "login")
	protected WebElement LoginButton;

	protected static int stepCounter = 1;

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected static Logger log;
	protected WaitHelper waitHelper;

	protected static final String URL = ConfigReader.getProperty("app.url");
	protected static final String USERNAME = ConfigReader.getProperty("app.username");
	protected static final String PASSWORD = ConfigReader.getProperty("app.password");

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		BasePage.log = new Logger();
		this.waitHelper = new WaitHelper(driver);
		PageFactory.initElements(driver, this);
	}

	public void userLogin() {
		try {
			driver.get(URL);
			waitHelper.staticWait(2000);
			Username.sendKeys(USERNAME);
			Password.sendKeys(PASSWORD + Keys.ENTER);
			log.info("Step " + stepCounter++ + ": Logged in successfully");
		} catch (Exception e) {
			log.error("Step " + stepCounter++ + ": Login failed.");
			throw new RuntimeException("Login Failed", e);
		}
	}

	public WebElement waitForElement(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected WebElement waitForElementVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	protected WebElement waitForElementClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	protected void click(WebElement element) {
		waitHelper.waitForElementToBeClickable(element);
		element.click();
	}

	protected void sendKeys(WebElement element, String text) {
		waitHelper.waitForElementToBeVisible(element);
		element.clear();
		element.sendKeys(text);
	}

	protected String getText(WebElement element) {
		waitHelper.waitForElementToBeVisible(element);
		return element.getText();
	}

	protected boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	protected void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void sleep(long millis) {
		waitHelper.staticWait(millis);
	}
}