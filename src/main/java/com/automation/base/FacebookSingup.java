package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookSingup {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		
		WebElement staticElementDay = driver.findElement(By.id("day"));
		WebElement staticElementMonth = driver.findElement(By.id("month"));
		WebElement staticElementYear = driver.findElement(By.id("year"));
		
		Select dropDownDay = new Select(staticElementDay);
		dropDownDay.selectByVisibleText("10");
		
		Select dropDownMonth = new Select(staticElementMonth);
		dropDownMonth.selectByVisibleText("Jul");
		
		
		Select dropDownYear = new Select(staticElementYear);
		dropDownYear.selectByVisibleText("2000");
		
		driver.quit();
		
	}

}
