package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.facebook.com");
		By.xpath("//input[@name='email']");
		By.xpath("//input[@id=’email’]");
		By.xpath("//input[@type='email']");
		By.xpath("//input[@class=’inputtext’]");
		By.xpath("//*[@class=’inputtext’]");
		By.xpath("//input[@class=’inputtext’][@type='email']");
		
		// Basic
		By.xpath("//a[@href='https://www.facebook.com/']");
		// Contains
		By.xpath("//*[contains(@name,'passwd_')]");
		// AND & OR
		By.xpath("//*[@class='inputtext' or @name='email']");
		By.xpath("//*[@class='inputtext' and @name='email']");
		// Start-with
		By.xpath("//*[starts-with(@id,'yui_3_18_0_3_1555510217471_')]");
		// Text
		By.xpath("//*[text(),"Create an account"]");
		// Last
		By.xpath("//input[@type='text'])[last()]");
		// Position
		By.xpath("//input[@type='text'])[2]");
		// Following
		By.xpath("//*[@name='firstname']");
		By.xpath("//*[@name='firstname']//following::input[@type='text']");
		By.xpath("//*[@name=’firstname’]//following::input[1]");
		// Preceding
		By.xpath("//*[@name='lastname']");
		By.xpath("//*[@name='lastname']//preceding::input[1]");
		By.xpath("[@name='lastname']//preceding::input[@type='text']");
		
		
		
	}

}
