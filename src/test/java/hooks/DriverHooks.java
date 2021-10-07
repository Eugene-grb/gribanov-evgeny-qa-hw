package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import web.drivers.BrowserName;
import web.drivers.WebDriverFactory;

@Slf4j
public class DriverHooks {
    protected static WebDriver driver;

    @Before
    public void startDriverBeforeScenario() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        driver = WebDriverFactory.getDriver(BrowserName.fromString(browser));
        log.info("Браузер стартовал!");
    }

    @After
    public void stopDriverAfterScenario() {
        if(driver != null) {
            driver.quit();
            log.info("Драйвер остановлен");
        }
    }
}
