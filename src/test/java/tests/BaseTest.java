package tests;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import web.driver.BrowserName;
import web.driver.WebDriverFactory;

@Log4j2
public class BaseTest {
    protected static WebDriver driver;

    String env = System.getProperty("browser", "chrome").toLowerCase();

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver(BrowserName.fromString(env));
        log.info("Драйвер стартовал!");
        log.info("-env: " + env);
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            log.info("Драйвер остановлен!");
        }
    }
}
