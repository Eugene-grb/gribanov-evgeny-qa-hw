package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.*;

public class Link extends BaseElement{

    public Link(WebElement webElement) {
        super(webElement);
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

    /** Нажатие на ссылку */
    public void click() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    /** Наведение курсора мыши на ссылку */
    public void focusOnLink() {
        ActionHelper.moveToElement(webElement);
    }

    // Получение ссылки
    public String getURL() {
        return webElement.getAttribute("href");
    }

    /** Получение текста ссылки */
    public String getText() {
        return webElement.getText();
    }
}
