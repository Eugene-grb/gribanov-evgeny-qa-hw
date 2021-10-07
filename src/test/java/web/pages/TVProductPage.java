package web.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import web.elements.Button;
import web.helpers.WaitHelper;

@Log4j2
public class TVProductPage extends BasePage {

    private static final String TABLE_COLUMN_MAIN = "//table[contains(@class, 'table-params')]/descendant::*[contains(text(),'%s')]";
    private static final String COLUMN_PATTERN = "/ancestor::tr/td[2]/div";
    private static final String CHARACTERISTIC_CARD_LINK = "//a[@data-tab-name='characteristics']";

    public TVProductPage(WebDriver driver) {
        super(driver);
    }

    public void pressCharacteristicButton() {
        Button characteristicButton = new Button(By.xpath(CHARACTERISTIC_CARD_LINK));
        characteristicButton.click();
        log.info("Нажата кнопка 'Характеристики'");
    }

    public String returnRightField(String nameField) {
        String TABLE_COLUMN = String.format(TABLE_COLUMN_MAIN, nameField);
        WebElement searchedRightElement = WaitHelper.searchRightElementForCompair(
                By.xpath(TABLE_COLUMN),
                By.xpath(TABLE_COLUMN.concat(COLUMN_PATTERN)));
        return searchedRightElement.getText();
    }
}
