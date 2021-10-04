package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.JavaScriptHelper;

public class MainBlock extends BaseElement {

    public MainBlock(WebElement webElement) {
        super(webElement);
    }

    /** Скрытие блока */
    public void hide() {
        JavaScriptHelper.displayNone(webElement);
    }
}
