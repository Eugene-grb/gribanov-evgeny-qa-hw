package web.elements;

import web.helpers.*;
import org.openqa.selenium.By;

public class Link extends BaseElement{

    public Link(By by) {
        super(by);
    }

    // Получение ссылки
    public String getURL() {
        return webElement.getAttribute("href");
    }

    /** Нажатие на ссылку */
    public void click() {
        WaitHelper.visibilityOfElementLocated(by);
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    /** Наведение курсора мыши на ссылку */
    public void focusOnLink() {
        WaitHelper.visibilityOfElementLocated(by);
        ActionHelper.moveToElement(webElement);
    }

    /** Открытие ссылки в новом окне
     * 1. Получение URL ссылки.
     * 2. Создание нового окна и переключение на него.
     * 3. Максимизация размеров окна.
     * 4. Переход по ссылке в новом окне */
    public void openInNewWindow() {
        String URL = this.getURL();
        SwitchHelper.switchToNewWindow();
        WindowHelper.maximizeWindow();
        NavigationHelper.navigateTo(URL);
    }

}
