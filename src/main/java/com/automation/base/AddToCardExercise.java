package com.automation.base;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToCardExercise {

	public static void main(String[] args) {

		int count = 0;

		String[] requiredProduct = { "Capsicum", "Mushroom", "Pumpkin", "Banana", "Cashews" };

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		List<WebElement> items = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < items.size(); i++) {
			String[] products = items.get(i).getText().split("-");
			String originalName = products[0].trim();

			List productName = Arrays.asList(requiredProduct);

			if (productName.contains(originalName)) {

				count++;

				driver.findElements(By.xpath("//*[@class='product-action']/button")).get(i).click();

				if (count == requiredProduct.length) {
					break;
				}
			}
		}

		driver.quit();
	}

}
