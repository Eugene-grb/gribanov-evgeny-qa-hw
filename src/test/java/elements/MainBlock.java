package elements;

import helpers.JSExecutor;
import helpers.WaitFor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainBlock extends BaseElement {

    public MainBlock(WebDriver driver, By by) {
        super(driver, by);
    }

    /** Скрытие блока */
    public void hide() {
        WaitFor.visibilityOfElementLocated(by);
        JSExecutor.displayNone(webElement);
    }
}
