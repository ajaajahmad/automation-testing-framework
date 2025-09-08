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

		// Initialize WebDriver (Chrome) and set browser properties
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().deleteAllCookies();

		// Open the target webpage
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// Click on the column header to trigger sorting (Product Name column)
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// Capture the product name column elements into a list
		List<WebElement> tableElements = driver.findElements(By.xpath("//tr/td[1]"));

		// Convert the list of WebElements to a list of Strings (product names)
		List<String> originalList = tableElements.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Create a sorted version of the product name list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// Compare the original list with the sorted list to verify sorting behavior
		Assert.assertTrue(originalList.equals(sortedList));

		// -------- PAGINATION SEARCH LOGIC --------
		// Goal: Search for product named "Rice" across multiple pages and print its price
		
		// To store price(s) once "Rice" is found
		List<String> priceList;

		do {
			// Capture the first column again (product names) for the current page
			List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));

			// Stream through rows to find product named "Rice" and get its price
			priceList = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getVeggiesPrice(s))
					.collect(Collectors.toList());

			// Print the price(s) found (could be more than one match on a page)
			priceList.forEach(a -> System.out.println(a));

			// If "Rice" not found, click 'Next' to move to the next page
			if (priceList.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}

			// Keep looping until "Rice" is found
		} while (priceList.size() < 1);

		// Close the browser session
		driver.quit();
	}

	// Utility method to get the price from the adjacent <td> element using XPath
	private static String getVeggiesPrice(WebElement s) {
		// This finds the next cell (td) in the same row — i.e., the price column
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
}