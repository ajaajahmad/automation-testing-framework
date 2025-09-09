package com.automation.base;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWindow {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		driver.switchTo().newWindow(WindowType.WINDOW);

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String parentWindow = it.next();
		String childWindow = it.next();

		driver.switchTo().window(childWindow);
		driver.get("https://courses.rahulshettyacademy.com");
		String courseText = driver.findElement(By.xpath("//div[contains(text(),'All-Access Membership')]")).getText();

		driver.switchTo().window(parentWindow);
		driver.findElements(By.cssSelector("input[name='name']")).get(1).sendKeys(courseText);
		WebElement nameField = driver.findElement(By.cssSelector("input[name='name']"));
		File file = nameField.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("name.png"));
		driver.quit();
	}
}