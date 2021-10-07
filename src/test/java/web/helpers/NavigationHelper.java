package web.helpers;


import web.driver.WebDriverFactory;

public class NavigationHelper {

    /** Открытие новой страницы */
    public static void navigateTo(String URL) {
        WebDriverFactory.getCurrentDriver().navigate().to(URL);
    }

    /** Переход на предыдущую страницу */
    public static void back() {
        WebDriverFactory.getCurrentDriver().navigate().back();
    }

    /** Переход на следующую страницу */
    public static void forward() {
        WebDriverFactory.getCurrentDriver().navigate().forward();
    }

    /** Обновление страницы */
    public static void refresh() {
        WebDriverFactory.getCurrentDriver().navigate().refresh();
    }
}
