package web.elements;

import org.openqa.selenium.WebElement;

public class BaseElement {

    protected WebElement webElement;

    public BaseElement(WebElement webElement) {
        this.webElement = webElement;
    }

    /** Получение оборачиваемого элемента */
    public WebElement getWebElement() {
        return webElement;
    }

}
