package com.automation.base;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		List<WebElement> options = driver.findElements(By.id("ctl00_mainContent_ddl_originStation1"));
		WebElement dropDown = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1"));
		
		String tagName = dropDown.getTagName();
		
		if(!tagName.equalsIgnoreCase("select")) {
			System.out.println("Dropdown is a <select> tag");
		}else {
			System.out.println("Dropdown is not a <select> tag");
		}
		
		if(options.size()>0) {
			System.out.println("Dropdown is empty");
		}else {
			System.out.println("Dropdown is not empty");
		}
		

//		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
//		
//		Thread.sleep(2000);
//		// driver.findElement(By.xpath("//a[@value='MAA']")).click();
//		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']"))
//				.click();
//
//		// driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();
//		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
//				.click();
//		Thread.sleep(2000);
		driver.quit();
	}

}
