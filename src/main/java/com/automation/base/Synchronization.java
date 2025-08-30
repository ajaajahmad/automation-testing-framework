package com.automation.base;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Synchronization {
	public static void main(String[] args) {
		String[] requiredProducts = { "Cucumber", "Broccoli", "Beetroot", "Carrot" };

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		addItems(driver, requiredProducts);
		driver.quit();
	}

	public static void addItems(WebDriver driver, String[] requiredProducts) {
		List<WebElement> productNameElements = driver.findElements(By.cssSelector("h4.product-name"));
		List<String> requiredProductsList = Arrays.asList(requiredProducts);
		int matchedProductsCount = 0;

		for (int i = 0; i < productNameElements.size(); i++) {
			String[] productTextParts = productNameElements.get(i).getText().split("-");

			// Format originalName to get requiredName
			String productName = productTextParts[0].trim();

			// Check if product name is in the required products list
			if (requiredProductsList.contains(productName)) {
				matchedProductsCount++;

				// Click the add to cart button for the matching product
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (matchedProductsCount == requiredProducts.length) {
					break;
				}
			}
		}
	}
}
