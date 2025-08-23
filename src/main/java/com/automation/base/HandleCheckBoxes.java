package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBoxes {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		//Print Total Number of Checkboxes;
		System.out.println(
				"Number of CheckBoxes is = " + driver.findElements(By.cssSelector("input[type=\"checkbox\"]")).size());

		System.out.println(
				"isSelected: " + driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
		System.out.println(
				"isSelected: " + driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());

		Thread.sleep(2000);

		driver.quit();

	}

}
