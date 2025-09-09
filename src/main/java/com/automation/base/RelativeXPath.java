package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeXPath {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		WebElement nameText = driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(RelativeLocator.with(By.tagName("label")).above(nameText)).getText());

		WebElement dateOfBirthText = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
		driver.findElement(RelativeLocator.with(By.cssSelector("input")).below(dateOfBirthText)).click();

		WebElement iceCreamLabel = driver
				.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
		
		driver.quit();
	}

}
