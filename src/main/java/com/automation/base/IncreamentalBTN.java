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

//		for (int click = 1; click < 5; click++) {
//			driver.findElement(By.xpath("//*[@data-testid='Adult-testID-plus-one-cta']")).click();
//		}

		System.out.println(driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n']//div//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']"))
				.getText());

		int click = 1;

		while (click < 5) {
			driver.findElement(By.xpath("//*[@data-testid='Adult-testID-plus-one-cta']")).click();
			click++;
		}

		System.out.println(driver.findElement(By.xpath(
				"//div[@class='css-1dbjc4n']//div//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']"))
				.getText());

		driver.quit();
	}

}
