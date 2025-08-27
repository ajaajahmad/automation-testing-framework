package com.automation.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddMutlipleProductToCard {

	public static void main(String[] args) {

		String[] productName = { "Cucumber", "Brocolli" };

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			String name = products.get(i).getText();

			if (name.contains("Cucumber")) {
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
			}
		}
		driver.quit();
	}

}
