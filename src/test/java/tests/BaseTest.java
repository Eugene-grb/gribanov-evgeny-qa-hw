package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import web.drivers.BrowserName;
import webdriverfactory.PageLoadStrategy;
import web.drivers.WebDriverFactory;

public class BaseTest {

    protected static WebDriver driver;
    private final Logger logger = LogManager.getLogger(BaseTest.class);

    String loadPageOption = System.getProperty("option", "normal").toLowerCase();
    String env = System.getProperty("browser", "chrome").toLowerCase();


    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver(
                BrowserName.fromString(env),
                PageLoadStrategy.fromString(loadPageOption));
        logger.info("Драйвер стартовал!");
        logger.info("-env: " + env + " -page load strategy: " + loadPageOption);
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
