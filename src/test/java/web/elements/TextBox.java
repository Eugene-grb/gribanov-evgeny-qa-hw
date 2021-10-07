package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class TextBox extends BaseElement {

    public TextBox(WebElement webElement) {
        super(webElement);
    }

    /** Нажатие на текстовое поле ввода */
    public void click() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    /** Ввод значения в текстовое поле ввода */
    public void setValue(String value) {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.sendKeys(value);
    }
}