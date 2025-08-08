package com.automation.base;

import com.automation.listeners.TestListener;
import com.automation.utils.ConfigManager;
import com.automation.utils.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;

import java.time.Duration;

@Listeners({TestListener.class})
public abstract class BaseTest {

    protected WebDriver driver;
    protected static final Logger logger = LogManager.getLogger(BaseTest.class);
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    @BeforeSuite
    public void beforeSuite() {
        ExtentReportManager.initializeReport();
        logger.info("Test suite started - " + this.getClass().getSimpleName());
    }

    @BeforeClass
    public void beforeClass() {
        logger.info("Starting test class: " + this.getClass().getSimpleName());
    }

    @BeforeMethod
    public void setUp() {
        String browserType = ConfigManager.getProperty("browser", "chrome");
        String applicationUrl = ConfigManager.getProperty("url");

        driver = initializeDriver(browserType);
        driverThreadLocal.set(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get(applicationUrl);

        logger.info("Browser '" + browserType + "' launched and navigated to: " + applicationUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
            logger.info("Browser closed");
        }
    }

    @AfterClass
    public void afterClass() {
        logger.info("Completed test class: " + this.getClass().getSimpleName());
    }

    @AfterSuite
    public void afterSuite() {
        ExtentReportManager.flushReport();
        logger.info("Test suite completed - " + this.getClass().getSimpleName());
    }

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    private WebDriver initializeDriver(String browserType) {
        WebDriver webDriver;
        String browser = browserType.toLowerCase();

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--disable-web-security");
                chromeOptions.addArguments("--disable-features=VizDisplayCompositor");

                if ("true".equalsIgnoreCase(ConfigManager.getProperty("headless", "false"))) {
                    chromeOptions.addArguments("--headless");
                    logger.info("Chrome running in headless mode");
                }

                webDriver = new ChromeDriver(chromeOptions);
                logger.info("Chrome driver initialized");
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();

                if ("true".equalsIgnoreCase(ConfigManager.getProperty("headless", "false"))) {
                    firefoxOptions.addArguments("--headless");
                    logger.info("Firefox running in headless mode");
                }

                webDriver = new FirefoxDriver(firefoxOptions);
                logger.info("Firefox driver initialized");
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--disable-notifications");
                edgeOptions.addArguments("--disable-popup-blocking");

                if ("true".equalsIgnoreCase(ConfigManager.getProperty("headless", "false"))) {
                    edgeOptions.addArguments("--headless");
                    logger.info("Edge running in headless mode");
                }

                webDriver = new EdgeDriver(edgeOptions);
                logger.info("Edge driver initialized");
                break;

            default:
                String errorMessage = "Browser not supported: " + browserType +
                        ". Supported: chrome, firefox, edge";
                logger.error(errorMessage);
                throw new IllegalArgumentException(errorMessage);
        }

        return webDriver;
    }
}