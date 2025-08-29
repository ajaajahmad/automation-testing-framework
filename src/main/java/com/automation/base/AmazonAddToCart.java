package com.automation.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAddToCart {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone");
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> productNameElement = driver
				.findElements(By.xpath("//span[contains(text()*=,'Apple iPhone')]"));

		for (int i = 0; i < productNameElement.size(); i++) {

			String machedProductName = productNameElement.get(i).getText();

			if (machedProductName.contains("iPhone")) {

				driver.findElements(By.xpath("//span[@class\"a-button-inner\"]/button")).get(i).click();
				break;
			}
		}

		driver.quit();
	}

}
