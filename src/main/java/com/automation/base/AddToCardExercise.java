package com.automation.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCardExercise {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < items.size(); i++) {
			String products = items.get(i).getText();

			if (products.contains("Capsicum")) {
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
			}
			break;
		}
		
		driver.quit();
	}

}
