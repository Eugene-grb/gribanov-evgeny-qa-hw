package web.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import web.drivers.WebDriverFactory;

public class SwitchHelper {
    /** Переключение на созданное окно */
    public static void switchToExistWindow(String window) {
        WebDriverFactory.getCurrentDriver().switchTo().window(window);
    }

    /** Переключение на создаваемое окно */
    public static void switchToNewWindow() {
        WebDriverFactory.getCurrentDriver().switchTo().newWindow(WindowType.WINDOW);
    }

    /** Переключение на создаваемую вкладку */
    public static void switchToNewTab() {
        WebDriverFactory.getCurrentDriver().switchTo().newWindow(WindowType.TAB);
    }

    /** Переключение на алерт */
    public static void switchToAlert() {
        WebDriverFactory.getCurrentDriver().switchTo().alert();
    }

    /** Переключение на фрейм по его индексу */
    public static void switchToFrameByIndex(int index) {
        WebDriverFactory.getCurrentDriver().switchTo().frame(index);
    }

    /** Переключение на фрейм по его атрибуту name или id */
    public static void switchToFrameByNameOrId(String nameOrId) {
        WebDriverFactory.getCurrentDriver().switchTo().frame(nameOrId);
    }

    /** Переключение на фрейм по веб элементу */
    public static void switchToFrameByFrameWebElement(WebElement webElement) {
        WebDriverFactory.getCurrentDriver().switchTo().frame(webElement);
    }

    /** Переключение на родительский фрейм */
    public static void switchToParentFrame() {
        WebDriverFactory.getCurrentDriver().switchTo().parentFrame();
    }

    /** Переключение на основной документ */
    public static void switchToDefaultContent() {
        WebDriverFactory.getCurrentDriver().switchTo().defaultContent();
    }

    /** Переключение на активный веб элемент */
    public static void switchToActiveWebElement() {
        WebDriverFactory.getCurrentDriver().switchTo().activeElement();
    }
}
