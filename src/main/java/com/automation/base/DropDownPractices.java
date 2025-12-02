package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownPractices {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://semantic-ui.com/modules/dropdown.html");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		WebElement countryOption = driver.findElement(By.xpath("//div[contains(text(), 'Select Country')]"));

		countryOption.click();
		
		

		driver.quit();
	}

}
