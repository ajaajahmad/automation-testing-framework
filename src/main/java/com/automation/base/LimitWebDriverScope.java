package com.automation.base;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LimitWebDriverScope {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footerLinks = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerLinks.findElements(By.tagName("a")).size());
		WebElement tableLinks = footerLinks.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(tableLinks.findElements(By.tagName("a")).size());

		List<WebElement> links = tableLinks.findElements(By.tagName("a"));

		for (int i = 1; i < links.size(); i++) {

			String keyboardEvents = Keys.chord(Keys.CONTROL, Keys.ENTER);

			tableLinks.findElements(By.tagName("a")).get(i).sendKeys(keyboardEvents);

			Thread.sleep(5000);
		}

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterate = windows.iterator();

		while (iterate.hasNext()) {
			driver.switchTo().window(iterate.next());
			System.out.println(driver.getTitle());
		}

	}
}