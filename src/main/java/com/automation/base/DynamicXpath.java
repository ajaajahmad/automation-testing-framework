package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicXpath {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.facebook.com");

		// --- Basic attribute-based XPaths ---
		By.xpath("//input[@name='email']");
		By.xpath("//input[@id='email']");
		By.xpath("//input[@type='email']");
		By.xpath("//input[@class='inputtext']");
		By.xpath("//*[@class='inputtext']");
		By.xpath("//input[@class='inputtext' and @type='email']");

		// --- Basic link ---
		By.xpath("//a[@href='https://www.facebook.com/']");

		// --- contains() function ---
		By.xpath("//*[contains(@name,'passwd_')]");

		// --- Logical operators: AND / OR ---
		By.xpath("//*[@class='inputtext' or @name='email']");
		By.xpath("//*[@class='inputtext' and @name='email']");

		// --- starts-with() function ---
		By.xpath("//*[starts-with(@id,'yui_3_18_0_3_1555510217471_')]");

		// --- text() function ---
		By.xpath("//*[text()='Create new account']");

		// --- last() function ---
		By.xpath("(//input[@type='text'])[last()]");

		// --- position() / index ---
		By.xpath("(//input[@type='text'])[2]");

		// --- following axis ---
		By.xpath("//*[@name='firstname']");
		By.xpath("//*[@name='firstname']//following::input[@type='text']");
		By.xpath("//*[@name='firstname']//following::input[1]");

		// --- preceding axis ---
		By.xpath("//*[@name='lastname']");
		By.xpath("//*[@name='lastname']//preceding::input[1]");
		By.xpath("//*[@name='lastname']//preceding::input[@type='text']");

		// Close browser
		driver.quit();
	}
}