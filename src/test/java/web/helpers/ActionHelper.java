package web.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import web.drivers.WebDriverFactory;

public class ActionHelper {
    protected static Actions actions;

    /** Инициализация действий */
    public static void init() {
        actions = new Actions(WebDriverFactory.getCurrentDriver());
    }

    /** Перемещение курсора мыши на элемент */
    public static void moveToElement(WebElement webElement) {
        actions.moveToElement(webElement).perform();
    }
}
