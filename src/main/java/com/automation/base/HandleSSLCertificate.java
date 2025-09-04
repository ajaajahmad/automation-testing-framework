package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSLCertificate {

	public static void main(String[] args) {
			
		WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		
		driver.get("");
	}

}
