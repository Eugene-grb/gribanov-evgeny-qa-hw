package web.elements;

import web.helpers.JavaScriptHelper;
import web.helpers.WaitHelper;
import org.openqa.selenium.By;

public class MainBlock extends BaseElement {

    public MainBlock(By by) {
        super(by);
    }

    /** Скрытие блока */
    public void hide() {
        WaitHelper.visibilityOfElementLocated(by);
        JavaScriptHelper.displayNone(webElement);
    }
}
