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

		String[] requiredProducts = { "Capsicum", "Mushroom", "Pumpkin", "Banana", "Cashews" };

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		addItemsToCard(driver, requiredProducts);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//div[@class='promoWrapper']/button")).click();
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

		driver.quit();
	}

	public static void addItemsToCard(WebDriver driver, String[] requiredProducts) {

		int matchedProductsCount = 0;

		List<WebElement> productNameElements = driver.findElements(By.cssSelector("h4.product-name"));

		List<String> requiredProductList = Arrays.asList(requiredProducts);

		for (int i = 0; i < productNameElements.size(); i++) {
			String[] productNameParts = productNameElements.get(i).getText().split("-");
			String productName = productNameParts[0].trim();

			if (requiredProductList.contains(productName)) {
				matchedProductsCount++;
				driver.findElements(By.xpath("//*[@class='product-action']/button")).get(i).click();

				if (matchedProductsCount == requiredProducts.length) {
					break;
				}
			}
		}
	}
}