package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.facebook.com");
		

By.xpath("//input[@name='email']")
By.xpath("//input[@id=’email’]")
By.xpath("//input[@type='email']")
By.xpath("//input[@class=’inputtext’]")
By.xpath("//*[@class=’inputtext’]")
By.xpath("//input[@class=’inputtext’][@type='email']")
	}

}
