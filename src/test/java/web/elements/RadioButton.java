package web.elements;

import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class RadioButton extends BaseElement {

    public RadioButton(WebElement webElement) {
        super(webElement);
    }

    /** Установка переключателя */
    public void setSelected(boolean value) {
        WaitHelper.clickabilityOfElement(webElement);
        if (value != isSelected()) {
            webElement.click();
        }
    }

    /** Проверка, что переключатель установлен */
    public boolean isSelected() {
        return webElement.isSelected();
    }
}
