package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IncreamentalBTN {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.spicejet.com/");

		driver.findElement(By.xpath("//div[text()='Passengers']")).click();

		for (int click = 1; click < 5; click++) {
			driver.findElement(By.xpath("//*[@data-testid='Adult-testID-plus-one-cta']")).click();
		}

		driver.quit();
	}

}
