package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import web.driver.BrowserName;
import web.driver.WebDriverFactory;

@Log4j2
public class DriverHooks {
    protected static WebDriver driver;

    String env = System.getProperty("browser", "chrome").toLowerCase();

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver(BrowserName.fromString(env));
        log.info("Драйвер стартовал!");
        log.info("-env: " + env);
    }

    @After
    public void setDown() {
        if(driver != null) {
            driver.quit();
            log.info("Драйвер остановлен!");
        }
    }
}
