package com.automation.base;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddMutlipleProductToCard {

	public static void main(String[] args) throws InterruptedException {
		int count = 0;
		String[] item = { "Cucumber", "Brocolli", "Beetroot" };

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {

			String[] originalName = products.get(i).getText().split("-");

			// Format originalName to get requiredName
			String requiredName = originalName[0].trim();

			// Convert array into array list for easy search
			// Check whether name you extracted is present in array or not
			List productName = Arrays.asList(item);

			if (productName.contains(requiredName)) {
				count++;
				driver.findElements(By.xpath("//*[@class=\"product-action\"]/button")).get(i).click();

				if (count == item.length) {
					break;
				}
			}

		}
		// driver.quit();
	}

}
