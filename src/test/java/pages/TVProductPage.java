package pages;

import elements.Button;
import helpers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;


public class TVProductPage extends BasePage {

    private final Logger logger = LogManager.getLogger(TVProductPage.class);

    private static final String CHARACTERISTIC_CARD_LINK = "//a[@data-tab-name='characteristics']";
    private static final String TABLE_COLUMN_MAIN = "//table[@class='table-params table-no-bordered']/descendant::*[contains(text(),'%s')]";
    private static final String RIGHT_COLUMN_COMPANY = "//table[@class='table-params table-no-bordered']/descendant::*[@id='pcv-zz9CQ-']";
    private static final String RIGHT_COLUMN_DIAGONAL = "//table[@class='table-params table-no-bordered']/descendant::*[@id='pcv-h6YqNv']";
    private static final String RIGHT_COLUMN_REFRESH_RATE = "//table[@class='table-params table-no-bordered']/descendant::*[@id='pcv-fCPUCv']";
    private static final String RIGHT_COLUMN_ILLUMINATION = "//table[@class='table-params table-no-bordered']/descendant::*[@id='p-il50e']";


    public TVProductPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Заголовок страницы: " + title);
        return title;
    }

    public void pressCharacteristicButton() {
        Button characteristicButton = new Button(driver, By.xpath(CHARACTERISTIC_CARD_LINK));
        characteristicButton.click();
        logger.info("Нажата кнопка 'Характеристики'");
    }

    public String returnCompanyField() {
        String nameField = "Модель";
        String COMPANY_FIELD = format(TABLE_COLUMN_MAIN, nameField);
        WebElement searchedRightElement = WaitFor.searchRightElementForCompair(
                By.xpath(COMPANY_FIELD),
                By.xpath(RIGHT_COLUMN_COMPANY));
        return searchedRightElement.getText();
    }

    public String returnDiagonalField() {
        String nameField = "Диагональ экрана (дюйм)";
        String COMPANY_FIELD = format(TABLE_COLUMN_MAIN, nameField);
        WebElement searchedRightElement = WaitFor.searchRightElementForCompair(
                By.xpath(COMPANY_FIELD),
                By.xpath(RIGHT_COLUMN_DIAGONAL));
        return searchedRightElement.getText();
    }

    public String returnRefreshField() {
        String nameField = "Частота обновления экрана (Гц)";
        String COMPANY_FIELD = format(TABLE_COLUMN_MAIN, nameField);
        WebElement searchedRightElement = WaitFor.searchRightElementForCompair(
                By.xpath(COMPANY_FIELD),
                By.xpath(RIGHT_COLUMN_REFRESH_RATE));
        return searchedRightElement.getText();
    }

    public String returnIlluminationField() {
        String nameField = "Тип подсветки";
        String COMPANY_FIELD = format(TABLE_COLUMN_MAIN, nameField);
        WebElement searchedRightElement = WaitFor.searchRightElementForCompair(
                By.xpath(COMPANY_FIELD),
                By.xpath(RIGHT_COLUMN_ILLUMINATION));
        return searchedRightElement.getText();
    }
}
