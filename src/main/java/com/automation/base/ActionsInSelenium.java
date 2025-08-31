package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsInSelenium {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.com/");

		Actions action = new Actions(driver);

		WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
		WebElement moveTo = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));

		action.moveToElement(searchBar).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		action.moveToElement(moveTo).contextClick().build().perform();

		driver.quit();
	}

}
