package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox extends BaseElement {

    public CheckBox(By by) {
        super(by);
    }

    /** Установка флажка */
    public void setChecked(boolean value) {
        if (value != isChecked()) {
            WaitHelper.clickabilityOfElement(webElement);
            webElement.click();
        }
    }

    /** Проверка, что флажок установлен */
    public boolean isChecked() {
        WaitHelper.visibilityOfElementLocated(by);
        return webElement.isSelected();
    }

}
