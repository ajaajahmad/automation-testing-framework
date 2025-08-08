package com.automation.listeners;

import com.automation.base.BaseTest;
import com.automation.utils.ExtentReportManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * TestNG listener for test execution events
 * Implements ITestListener for TestNG compatibility
 */
public class TestListener implements ITestListener {
    private static final Logger logger = LogManager.getLogger(TestListener.class);
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String testDescription = result.getMethod().getDescription();
        
        ExtentTest test = ExtentReportManager.createTest(testName, testDescription);
        extentTest.set(test);
        
        logger.info("Starting test: " + testName);
        test.log(Status.INFO, "Test started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        logger.info("Test passed: " + testName);
        
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.log(Status.PASS, "Test passed: " + testName);
        }
        
        extentTest.remove();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String errorMessage = result.getThrowable().getMessage();
        
        logger.error("Test failed: " + testName + " - Error: " + errorMessage);
        
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.log(Status.FAIL, "Test failed: " + testName);
            test.log(Status.FAIL, "Error: " + errorMessage);
            
            // Capture screenshot on failure
            String screenshotPath = captureScreenshot(testName);
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath);
            }
        }
        
        extentTest.remove();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        String skipReason = result.getThrowable() != null ? result.getThrowable().getMessage() : "Unknown reason";
        
        logger.warn("Test skipped: " + testName + " - Reason: " + skipReason);
        
        ExtentTest test = extentTest.get();
        if (test != null) {
            test.log(Status.SKIP, "Test skipped: " + testName);
            test.log(Status.SKIP, "Reason: " + skipReason);
        }
        
        extentTest.remove();
    }

    /**
     * Get current ExtentTest instance
     */
    public static ExtentTest getCurrentTest() {
        return extentTest.get();
    }

    /**
     * Capture screenshot and return file path
     */
    private String captureScreenshot(String testName) {
        try {
            WebDriver driver = BaseTest.getDriver();
            if (driver == null) {
                logger.warn("WebDriver is null, cannot capture screenshot");
                return null;
            }

            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String fileName = testName + "_" + timestamp + ".png";
            String filePath = "reports/screenshots/" + fileName;
            
            // Create directory if it doesn't exist
            Files.createDirectories(Paths.get("reports/screenshots/"));
            
            // Write screenshot to file
            Files.write(Paths.get(filePath), screenshot);
            
            logger.info("Screenshot captured: " + filePath);
            return filePath;
            
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: " + e.getMessage());
            return null;
        } catch (Exception e) {
            logger.error("Unexpected error while capturing screenshot: " + e.getMessage());
            return null;
        }
    }
}