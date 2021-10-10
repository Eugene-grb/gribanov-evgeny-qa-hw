package web.pages;

import web.helpers.ActionHelper;
import web.helpers.JavaScriptHelper;
import web.helpers.WaitHelper;
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
        WaitHelper.initWait(DURATION_TIMEOUT, DURATION_SLEEP);
        JavaScriptHelper.initJS();
        ActionHelper.init();
    }

    /** Получение заголовка текущей страницы */
    public static String getPageTitle() {
        return driver.getTitle();
    }
}
