package com.automation.base;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownPractices {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://semantic-ui.com/modules/dropdown.html");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		By dropdownLocator = By.xpath("//div[contains(text(), 'Select Country')]");
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));

		dropdown.click();

		By itemLocator = By.cssSelector(".menu .item");
		wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
		List<WebElement> allListItem = dropdown.findElements(itemLocator);

		for (WebElement allOption : allListItem) {
			
			String text = allOption.getText();
			
			String value = allOption.getAttribute("af");
			
			System.out.println(text +""+""+ value);
			
			driver.quit();
		}

	}
}