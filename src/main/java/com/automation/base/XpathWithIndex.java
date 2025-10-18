package com.automation.base;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class XpathWithIndex {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		driver.get("https://www.fantasticfurniture.com.au/");
		WebElement menu = wait.until(drv -> drv.findElement(By.xpath("//nav[@aria-label='menuItem'][2]/a")));
		menu.click();
		WebElement submenu = wait.until(drv -> drv.findElement(By.xpath("(//div[@class='desktop-submenu'])[1]//ul/li[2]/a")));
		submenu.click();
		driver.quit();
	}

}
