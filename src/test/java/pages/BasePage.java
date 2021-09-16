package pages;

import helpers.JSExecutor;
import helpers.WaitFor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public abstract class BasePage {

    protected static WebDriver driver;
    private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(10);
    private static final Duration DURATION_SLEEP = Duration.ofSeconds(10);

    // Конструктор базового класса
    // инициализация ожиданий и исполнителя JS скриптов
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        WaitFor.initWait(driver, DURATION_TIMEOUT, DURATION_SLEEP);
        JSExecutor.initJS(driver);
    }
}
