package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutor {

    private static final Logger logger = LogManager.getLogger(JSExecutor.class);
    protected static JavascriptExecutor js;

    /** Инициализация исполнителя Js скриптов */
    public static void initJS(WebDriver driver) {
        js = (JavascriptExecutor) driver;
    }

    /** Скролл страницы на заданное расстояние в пикселях по X и по Y */
    public static void scrollBy(int x, int y) {
        String script = "window.scrollBy(" + x + "," + y + ");";
        js.executeScript(script);
    }

    /** Установка невидимости веб элемента */
    public static void displayNone(WebElement element) {
        String script = "arguments[0].style.display='none';";
        js.executeScript(script, element);
    }
}
