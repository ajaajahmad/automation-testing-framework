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

public class ExtentReportManager {
	private static ExtentReports extentReports;
	private static ExtentSparkReporter sparkReporter;
	private static final Logger logger = LogManager.getLogger(ExtentReportManager.class);
	private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

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

	public static ExtentTest createTest(String testName, String description) {
		ExtentTest test = extentReports.createTest(testName, description);
		extentTest.set(test);
		return test;
	}

	public static ExtentTest getCurrentTest() {
		return extentTest.get();
	}

	public static void flushReport() {
		if (extentReports != null) {
			extentReports.flush();
			logger.info("Extent Report flushed");
		}
	}

	private static String getReportPath() {
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		String reportDir = Constants.REPORTS_PATH;

		File directory = new File(reportDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		return reportDir + "TestReport_" + timestamp + ".html";
	}

	private static void configureReport() {
		sparkReporter.config().setDocumentTitle(Constants.REPORT_TITLE);
		sparkReporter.config().setReportName(Constants.REPORT_NAME);
		sparkReporter.config().setTheme(Theme.STANDARD);
		sparkReporter.config().setEncoding("utf-8");

	}

	private static void setSystemInfo() {
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
		extentReports.setSystemInfo("User", System.getProperty("user.name"));
		extentReports.setSystemInfo("Browser", ConfigUtils.getProperty("browser"));
		extentReports.setSystemInfo("Environment", ConfigUtils.getProperty("environment"));
		extentReports.setSystemInfo("URL", ConfigUtils.getProperty("url"));
	}
}