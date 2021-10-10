package web.elements;

import web.driver.WebDriverFactory;
import web.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BaseElement {

    protected WebElement webElement;
    protected By by;
    private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(3);
    private static final Duration DURATION_SLEEP = Duration.ofSeconds(3);

    public BaseElement(By by) {
        this.by = by;
        WaitHelper.initWait(DURATION_TIMEOUT, DURATION_SLEEP);
        WaitHelper.presenceOfElementLocated(by);
        webElement = WebDriverFactory.getCurrentDriver().findElement(by);
    }

    /** Получение оборачиваемого элемента
     * Получив оборачиваемый элемент, можно вызвать его методы
     * Например, getText() */
    public WebElement getWebElement() {
        return webElement;
    }
}
