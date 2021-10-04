package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class Button extends BaseElement {

    // Конструктор
    public Button(WebElement webElement) {
        super(webElement);
    }

    /** Нажатие на кнопку */
    public void click() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
