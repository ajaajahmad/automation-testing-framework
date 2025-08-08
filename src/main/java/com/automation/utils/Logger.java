package com.automation.utils;

import org.apache.logging.log4j.LogManager;

public class Logger {

	private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class);

	public void info(String message) {
		logger.info(message);
	}

	public void warn(String message) {
		logger.warn(message);
	}

	public void error(String message) {
		logger.error(message);
	}

	public void startTestStep(String stepName) {
		logger.info("===== START: {} =====", stepName);
	}

	public void endTestStep(String stepName, String status) {
		logger.info("===== END: {} | Status: {} =====", stepName, status.toUpperCase());
	}

	public void element(String elementName, String action, String value) {
		logger.debug("[ELEMENT] {} - Action: {} - Value: {}", elementName, action, value);
	}

	public void element(String elementName, String action) {
		logger.debug("[ELEMENT] {} - Action: {}", elementName, action);
	}

	public void startTestCase(String testCaseName) {
		logger.info("********** Starting Test Case: {} **********", testCaseName);
	}

	public void endTestCase(String testCaseName) {
		logger.info("********** Ending Test Case: {} **********", testCaseName);
	}
}