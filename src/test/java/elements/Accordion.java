package elements;

import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Accordion extends BaseElement {

    public Accordion(WebDriver driver, By by) {
        super(driver, by);
    }

    /** Раскрытие гармошки */
    public void show() {
        WaitFor.visibilityOfElementLocated(by);
        WaitFor.clickabilityOfElement(webElement);
        webElement.click();
    }
}
