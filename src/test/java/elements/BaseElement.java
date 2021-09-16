package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BaseElement {

    protected WebElement webElement;
    protected WebDriver driver;
    protected By by;
    private static final Duration DURATION_TIMEOUT = Duration.ofSeconds(3);
    private static final Duration DURATION_SLEEP = Duration.ofSeconds(3);

    // базовый конструктор
    public BaseElement(WebDriver driver, By by) {
        this.driver = driver;
        this.by = by;
        // Ожидание появления элемента перед поиском элемента
        WaitFor.initWait(driver, DURATION_TIMEOUT, DURATION_SLEEP);
        WaitFor.presenceOfElementLocated(by);
        // Поиск веб элемента
        webElement = driver.findElement(by);
    }

    /** Получение оборачиваемого элемента
     * Получив оборачиваемый элемент, можно вызвать его методы
     * Например, getText() */
    public WebElement getWebElement() {
        return webElement;
    }

}
