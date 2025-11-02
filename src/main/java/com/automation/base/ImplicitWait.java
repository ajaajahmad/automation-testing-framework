package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class ImplicitWait {

	public static void main(String[] args) {

		WebDriver driver = null;

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
}