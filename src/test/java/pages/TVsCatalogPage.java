package pages;

import elements.*;
import helpers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class TVsCatalogPage extends BasePage {

    private final Logger logger = LogManager.getLogger(TVsCatalogPage.class);

    private static final String SORT_CHEAP_BUTTON = "//a[@class='ui-link ui-link_blue']/descendant-or-self::*[text()='Сначала недорогие']";
    private static final String SORT_EXPENSIVE_BUTTON = "//span[@class='ui-radio__content']/descendant-or-self::*[text()='Сначала дорогие']";
    private static final String APPLY_FILTERS_BUTTON = "//div[@class='apply-filters-float-btn']";
    private static final String FIRST_PRODUCT_IN_LIST_LINK = "//div[@data-id='product']/*[@class='catalog-product__name ui-link ui-link_black'][1]";
    private static final String ACCORDION_FILTERS = "//div[@data-id='fr[p2]']//span[starts-with(text(),'%s')]";
    private static final String ILLUMINATION_TYPE_FILTER = "//div[@data-id='f[rh2]']//span[starts-with(text(),'%s')]";


    public TVsCatalogPage(WebDriver driver) {
        super(driver);
    }

    public void openPriceSortingButton() {
        Button sortCheapButton = new Button(driver, By.xpath(SORT_CHEAP_BUTTON));
        sortCheapButton.click();
        logger.info("Открыто меню сортировки по цене");
    }

    public void setExpensiveSortButton() {
        Button sortExpensiveButton = new Button(driver, By.xpath(SORT_EXPENSIVE_BUTTON));
        sortExpensiveButton.click();
        logger.info("Установлена сортировка 'сначала дорогие'");
    }

    public void setCompanyCheckbox(String company) {
        String MANUFACTURER_CHECKBOX = "//div[@data-id='brand']/descendant-or-self::*[@value='%s']";
        String COMPANY_CHECKBOX = format(MANUFACTURER_CHECKBOX, company);
        CheckBox checkBoxCompany = new CheckBox(driver, By.xpath(COMPANY_CHECKBOX));
        checkBoxCompany.setChecked(true);
        logger.info("Установлен фильтр 'Производитель' - " + company);
    }

    public void openDiagonalAccordion(String accordionName) {
        String DIAGONAL_ACCORDION = format(ACCORDION_FILTERS, accordionName);
        Accordion diagonalAccordion = new Accordion(driver, By.xpath(DIAGONAL_ACCORDION));
        diagonalAccordion.show();
        logger.info("Открыто подменю фильтра - " + accordionName);
    }

    public void setValueInDiagonalTextFieldInitial(String initialValue) {
        String INITIAL_VALUE_DIAGONAL_FIELD = "//div[@data-id='fr[p2]']/descendant-or-self::*[@placeholder='от 22']";
        TextBox initialValueTextBox = new TextBox(driver, By.xpath(INITIAL_VALUE_DIAGONAL_FIELD));
        initialValueTextBox.click();
        initialValueTextBox.setValue(initialValue);
        logger.info("Установлено начальное значение фильтра 'Диагональ экрана' - " + initialValue);
    }

    public void setValueInDiagonalTextFieldFinal(String finalValue) {
        String FINAL_VALUE_DIAGONAL_FIELD = "//div[@data-id='fr[p2]']/descendant-or-self::*[@placeholder='до 88']";
        TextBox finalValueTextBox = new TextBox(driver, By.xpath(FINAL_VALUE_DIAGONAL_FIELD));
        finalValueTextBox.click();
        finalValueTextBox.setValue(finalValue);
        logger.info("Установлено конечное значение фильтра 'Диагональ экрана' - " + finalValue);
    }

    public void openScreenRefreshRateAccordion(String accordionName) {
        String SCREEN_REFRESH_ACCORDION = format(ACCORDION_FILTERS, accordionName);
        Accordion screenRefreshAccordion = new Accordion(driver, By.xpath(SCREEN_REFRESH_ACCORDION));
        screenRefreshAccordion.show();
        logger.info("Открыто подменю фильтра - " + accordionName);
    }

    public void setScreenRefreshRateFilterCheckbox(String refreshValue) {
        String SCREEN_REFRESH_RATE_FILTER = "//div[@data-id='f[adg]']//span[starts-with(text(),'%s')]";
        String REFRESH_RATE_CHECKBOX = format(SCREEN_REFRESH_RATE_FILTER, refreshValue);
        CheckBox refreshRateCheckbox = new CheckBox(driver, By.xpath(REFRESH_RATE_CHECKBOX));
        refreshRateCheckbox.setChecked(true);
        logger.info("Установлен фильтр 'Частота экрана (Гц)' - " + refreshValue);
    }

    public void openIlluminationTypeAccordion(String accordionName) {
        String ILLUMINATION_TYPE_ACCORDION = format(ILLUMINATION_TYPE_FILTER, accordionName);
        Accordion illuminationTypeAccordion = new Accordion(driver, By.xpath(ILLUMINATION_TYPE_ACCORDION));
        illuminationTypeAccordion.show();
        logger.info("Открыто подменю фильтра - " + accordionName);
    }

    public void setIlluminationTypeFilterCheckbox(String illuminationType) {
        String ILLUMINATION_TYPE_CHECKBOX = format(ILLUMINATION_TYPE_FILTER, illuminationType);
        CheckBox illuminationTypeCheckbox = new CheckBox(driver, By.xpath(ILLUMINATION_TYPE_CHECKBOX));
        illuminationTypeCheckbox.setChecked(true);
        logger.info("Установлен фильтр 'Тип подсветки экрана' - " + illuminationType);
    }

    public void applyFiltersButtonClick() {
        Button buttonApply = new Button(driver, By.xpath(APPLY_FILTERS_BUTTON));
        buttonApply.click();
        logger.info("Нажата кнопка \"Применить\"");
    }

    public void firstProductLinkClick(String product) {
        WaitFor.firstProductMustBe(By.xpath(FIRST_PRODUCT_IN_LIST_LINK), product);
        Link linkProduct = new Link(driver, By.xpath(FIRST_PRODUCT_IN_LIST_LINK));
        linkProduct.openInNewWindow();
        logger.info("Нажата ссылка первого продукта в списке");
    }

}
