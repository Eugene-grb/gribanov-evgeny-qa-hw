package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends BaseElement {

    // Конструктор
    public Button(By by) {
        super(by);
    }

    /** Нажатие на кнопку */
    public void click() {
        WaitHelper.visibilityOfElementLocated(by);
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
