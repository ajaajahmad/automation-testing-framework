package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {

		WebDriver driver = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
	}

}
