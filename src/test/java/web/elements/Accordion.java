package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class Accordion extends BaseElement {

    public Accordion(WebElement webElement) {
        super(webElement);
    }

    /** Раскрытие гармошки */
    public void show() {
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
