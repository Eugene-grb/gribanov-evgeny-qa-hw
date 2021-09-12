package pages;

import elements.*;
import helpers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.String.format;

public class TVsCatalogPage extends BasePage {

    private static final String SORT_CHEAP_BUTTON = "//a[@class='ui-link ui-link_blue']/descendant-or-self::*[text()='Сначала недорогие']";
    private static final String SORT_EXPENSIVE_BUTTON = "//span[@class='ui-radio__content']/descendant-or-self::*[text()='Сначала дорогие']";
    private static final String APPLY_FILTERS_BUTTON = "//div[@class='apply-filters-float-btn']";
    private static final String FIRST_PRODUCT_IN_LIST_LINK = "//div[@data-id='product']/*[@class='catalog-product__name ui-link ui-link_black'][1]";
    private static final String INITIAL_VALUE_DIAGONAL_FIELD = "//div[@data-id='fr[p2]']/descendant-or-self::*[@placeholder='от 22']";
    private static final String FINAL_VALUE_DIAGONAL_FIELD = "//div[@data-id='fr[p2]']/descendant-or-self::*[@placeholder='до 88']";
    private static String ACCORDION_FILTERS = "//div[@data-id='fr[p2]']//span[starts-with(text(),'%s')]";
    private static String ILLUMINATION_TYPE_FILTER = "//div[@data-id='f[rh2]']//span[starts-with(text(),'%s')]";
    private static String MANUFACTURER_CHECKBOX = "//span[contains(text(), \"%s\")]";
    private static String SCREEN_REFRESH_RATE_FILTER = "//div[@data-id='f[adg]']//span[starts-with(text(),'%s')]";


    private final Logger logger = LogManager.getLogger(TVsCatalogPage.class);

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
        MANUFACTURER_CHECKBOX = MANUFACTURER_CHECKBOX.replace("%s", company);
        CheckBox checkBoxCompany = new CheckBox(driver, By.xpath(MANUFACTURER_CHECKBOX));
        checkBoxCompany.setChecked(true);
        logger.info("Установлен фильтр 'Производитель' - " + company);
    }

    public void openDiagonalAccordion(String accordionName) {
        ACCORDION_FILTERS = ACCORDION_FILTERS.replace("%s", accordionName);
        Accordion diagonalAccordion = new Accordion(driver, By.xpath(ACCORDION_FILTERS));
        diagonalAccordion.show();
        logger.info("Открыто подменю фильтра - " + accordionName);
    }

    public void setValueInDiagonalTextFieldInitial(String initialValue) {
        TextBox initialValueTextBox = new TextBox(driver, By.xpath(INITIAL_VALUE_DIAGONAL_FIELD));
        initialValueTextBox.click();
        initialValueTextBox.setValue(initialValue);
        logger.info("Установлено начальное значение фильтра 'Диагональ экрана' - " + initialValue);
    }

    public void setValueInDiagonalTextFieldFinal(String finalValue) {
        TextBox finalValueTextBox = new TextBox(driver, By.xpath(FINAL_VALUE_DIAGONAL_FIELD));
        finalValueTextBox.click();
        finalValueTextBox.setValue(finalValue);
        logger.info("Установлено конечное значение фильтра 'Диагональ экрана' - " + finalValue);
    }

    public void openScreenRefreshRateAccordion(String accordionName) {
        ACCORDION_FILTERS = ACCORDION_FILTERS.replace("%s", accordionName);
        Accordion screenRefreshAccordion = new Accordion(driver, By.xpath(ACCORDION_FILTERS));
        screenRefreshAccordion.show();
        logger.info("Открыто подменю фильтра - " + accordionName);
    }

    public void setScreenRefreshRateFilterCheckbox(String refreshValue) {
        SCREEN_REFRESH_RATE_FILTER = SCREEN_REFRESH_RATE_FILTER.replace("%s",refreshValue);
        CheckBox refreshRateCheckbox = new CheckBox(driver, By.xpath(SCREEN_REFRESH_RATE_FILTER));
        refreshRateCheckbox.setChecked(true);
        logger.info("Установлен фильтр 'Частота экрана (Гц)' - " + refreshValue);
    }

    public void openIlluminationTypeAccordion(String accordionName) {
        ILLUMINATION_TYPE_FILTER = ILLUMINATION_TYPE_FILTER.replace("%s", accordionName);
        Accordion illuminationTypeAccordion = new Accordion(driver, By.xpath(ILLUMINATION_TYPE_FILTER));
        illuminationTypeAccordion.show();
        logger.info("Открыто подменю фильтра - " + accordionName);
    }

    public void setIlluminationTypeFilterCheckbox(String illuminationType) {
        ILLUMINATION_TYPE_FILTER = ILLUMINATION_TYPE_FILTER.replace("%s", illuminationType);
        CheckBox illuminationTypeCheckbox = new CheckBox(driver, By.xpath(ILLUMINATION_TYPE_FILTER));
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
