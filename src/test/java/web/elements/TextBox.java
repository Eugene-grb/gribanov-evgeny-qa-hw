package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Класс "Текстовое поле ввода"
public class TextBox extends BaseElement {

    public TextBox(By by) {
        super(by);
    }

    /** Нажатие на текстовое поле ввода */
    public void click() {
        WaitHelper.visibilityOfElementLocated(by);
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }

    /** Ввод значения в текстовое поле ввода */
    public void setValue(String value) {
        WaitHelper.visibilityOfElementLocated(by);
        webElement.sendKeys(value);
    }
}
