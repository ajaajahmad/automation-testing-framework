package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Extent Report Manager for generating test reports
public class ExtentReportManager {
	private static ExtentReports extentReports;
	private static ExtentSparkReporter sparkReporter;
	private static final Logger logger = LogManager.getLogger(ExtentReportManager.class);
	private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	// Initialize Extent Reports
	public static void initializeReport() {
		if (extentReports == null) {
			String reportPath = getReportPath();

			sparkReporter = new ExtentSparkReporter(reportPath);
			extentReports = new ExtentReports();
			extentReports.attachReporter(sparkReporter);

			configureReport();
			setSystemInfo();

			logger.info("Extent Report initialized: " + reportPath);
		}
	}

	// Create a new test in the report
	public static ExtentTest createTest(String testName, String description) {
		ExtentTest test = extentReports.createTest(testName, description);
		extentTest.set(test);
		return test;
	}

	// Get current test instance
	public static ExtentTest getCurrentTest() {
		return extentTest.get();
	}

	// Flush the report
	public static void flushReport() {
		if (extentReports != null) {
			extentReports.flush();
			logger.info("Extent Report flushed");
		}
	}

	// Generate report file path with timestamp
	private static String getReportPath() {
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		String reportDir = Constants.REPORTS_PATH;

		// Create directory if it doesn't exist
		File directory = new File(reportDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		return reportDir + "TestReport_" + timestamp + ".html";
	}

	// Configure report settings
	private static void configureReport() {
		sparkReporter.config().setDocumentTitle(Constants.REPORT_TITLE);
		sparkReporter.config().setReportName(Constants.REPORT_NAME);
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setEncoding("utf-8");

		// Set custom CSS or JS if needed
		// sparkReporter.config().setCss("css-string");
		// sparkReporter.config().setJs("js-string");
	}

	// Set system information in the report
	private static void setSystemInfo() {
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("User", System.getProperty("user.name"));
		extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
		extentReports.setSystemInfo("Environment", ConfigReader.getProperty("environment"));
		extentReports.setSystemInfo("URL", ConfigReader.getProperty("url"));
	}
}