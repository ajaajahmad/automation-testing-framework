package com.automation.base;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutomatingPaginationScenario {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		// click on the column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		// capture the web elements inot alist
		List<WebElement> tableElements = driver.findElements(By.xpath("//tr/td[1]"));
		// capture all web element list into a new (original) list
		List<String> originalList = tableElements.stream().map(s -> s.getText()).collect(Collectors.toList());
		// sort on original list - step 3 sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		// compare sorted list with original list
		Assert.assertTrue(originalList.equals(sortedList));

		// scan the name column with getText and print the price of "Rice"
		List<String> priceList;
		do {
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
			priceList = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getVeggiesPrice(s))
					.collect(Collectors.toList());
			priceList.forEach(a -> System.out.println(a));
			if (priceList.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		} while (priceList.size() < 1);

		driver.quit();
	}

	private static String getVeggiesPrice(WebElement s) {

		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();

		return priceValue;
	}

}
