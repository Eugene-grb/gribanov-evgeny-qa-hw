package web.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import web.helpers.WaitHelper;

public class Table extends BaseElement {

    public Table(By by) {
        super(by);
    }

    /** Получение значения ячеек таблицы */
    public String getDataValue(String dataName) {
        WaitHelper.visibilityOfElementLocated(by);
        String xpath = "//table//td//span[contains(text(), \"" + dataName +
                "\")]/ancestor::td/following-sibling::td//span";
        return webElement.findElement(By.xpath(xpath)).getText();
    }
}
