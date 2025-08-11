package com.automation.base;

import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeBrowser {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}

}
