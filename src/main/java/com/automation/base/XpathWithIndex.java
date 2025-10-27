package com.automation.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class XpathWithIndex {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Create WebDriverWait instance (Explicit Wait)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.fantasticfurniture.com.au/");

        // Wait for and hover over the 2nd menu item
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("(//nav[@aria-label='menuItem'])[2]/a")
        ));

        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();

        // Wait until submenu is visible and click on "King Single Beds"
        WebElement submenu = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[normalize-space()='King Single Beds']")
        ));

        submenu.click();

        driver.quit();
    }
}