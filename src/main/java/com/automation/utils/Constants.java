package com.automation.utils;

/**
 * Constants used throughout the framework
 */
public class Constants {
    // Timeouts
    public static final int EXPLICIT_WAIT_TIMEOUT = 10;
    public static final int IMPLICIT_WAIT_TIMEOUT = 10;
    public static final int PAGE_LOAD_TIMEOUT = 30;
    
    // File paths
    public static final String TEST_DATA_PATH = "src/main/resources/testdata/";
    public static final String REPORTS_PATH = "reports/extent-reports/";
    public static final String SCREENSHOTS_PATH = "reports/screenshots/";
    
    // Report settings
    public static final String REPORT_NAME = "Automation Test Report";
    public static final String REPORT_TITLE = "Test Execution Report";
    
    // Browser settings
    public static final String DEFAULT_BROWSER = "chrome";
    public static final String DEFAULT_ENVIRONMENT = "qa";
}