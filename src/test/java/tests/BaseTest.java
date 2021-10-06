package tests;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import web.drivers.BrowserName;
import web.drivers.WebDriverFactory;

@Slf4j
public class BaseTest {

    protected static WebDriver driver;
    String env = System.getProperty("browser", "chrome").toLowerCase();

    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.getDriver(BrowserName.fromString(env));
        log.info("Драйвер стартовал!");
        log.info("env: " + env);
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            log.info("Драйвер остановлен!");
        }
    }
}
