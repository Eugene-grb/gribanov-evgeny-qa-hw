package web.helpers;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import web.drivers.WebDriverFactory;

public class WindowHelper {
    /** Минимизация размеров окна */
    public static void minimizeWindow() {
        WebDriverFactory.getCurrentDriver().manage().window().minimize();
    }

    /** Максимизация размеров окна */
    public static void maximizeWindow () {
        WebDriverFactory.getCurrentDriver().manage().window().maximize();
    }

    /** Отображение окна браузера в полноэкранном режиме */
    public static void fullscreenWindow () {
        WebDriverFactory.getCurrentDriver().manage().window().fullscreen();
    }

    /** Получение координат расположения окна */
    public static Point getWindowPosition() {
        return WebDriverFactory.getCurrentDriver().manage().window().getPosition();
    }

    /** Установка координат расположения окна */
    public static void setWindowPosition(Point position) {
        WebDriverFactory.getCurrentDriver().manage().window().setPosition(position);
    }

    /** получение размеров окна */
    public static Dimension getWindowSize() {
        return WebDriverFactory.getCurrentDriver().manage().window().getSize();
    }

    /** Установка размеров окна */
    public static void setWindowSize(Dimension dimension) {
        WebDriverFactory.getCurrentDriver().manage().window().setSize(dimension);
    }
}
