package web.elements;

import web.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButton extends BaseElement {

    public RadioButton(By by) {
        super(by);
    }

    /** Установка переключателя */
    public void setSelected(boolean value) {
        if (value != isSelected()) {
            WaitHelper.clickabilityOfElement(webElement);
            webElement.click();
        }
    }

    /** Проверка, что переключатель установлен */
    public boolean isSelected() {
        WaitHelper.visibilityOfElementLocated(by);
        return webElement.isSelected();
    }
}
