package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.By;

public class Accordion extends BaseElement {

    public Accordion(By by) {
        super(by);
    }

    /** Раскрытие гармошки */
    public void show() {
        WaitHelper.visibilityOfElementLocated(by);
        WaitHelper.clickabilityOfElement(webElement);
        webElement.click();
    }
}
