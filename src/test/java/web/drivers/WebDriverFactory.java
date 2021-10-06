package web.drivers;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class WebDriverFactory {
    private static WebDriver webDriver;

    public static WebDriver getDriver(BrowserName name) {
        switch (name) {
            case CHROME:
                log.info("Драйвер для браузера Google Chrome");
                webDriver = ChromeBrowser.getDriver();
                return webDriver;
            case FIREFOX:
                log.info("Драйвер для браузера Mozilla Firefox");
                webDriver = FirefoxBrowser.getDriver();
                return webDriver;
            case EDGE:
                log.info("Драйвер для браузера Microsoft Edge");
                webDriver = EdgeBrowser.getDriver();
                return webDriver;
            default:
                throw new RuntimeException("Некорректное имя браузера");
        }
    }

    /** Получение уже созданного экземпляра драйвера */
    public static WebDriver getCurrentDriver() {
        return webDriver;
    }
}
