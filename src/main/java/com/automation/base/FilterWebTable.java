package com.automation.base;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FilterWebTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.id("search-field")).sendKeys("Rice");

		List<WebElement> filteredElement = driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredList = filteredElement.stream().filter(veggies -> veggies.getText().contains("Rice"))
				.collect(Collectors.toList());

		Assert.assertEquals(filteredList.size(), filteredElement.size());

		driver.quit();
	}

}
