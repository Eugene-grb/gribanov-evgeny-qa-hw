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
    private static final String SET_FILTER_VALUE = "//div[@data-role='filters-container']//span[starts-with(text(),'%s')]";


    private final Logger logger = LogManager.getLogger(TVsCatalogPage.class);

    public TVsCatalogPage(WebDriver driver) {
        super(driver);
    }

    // СОРТИРОВКА ПО ЦЕНЕ
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

    // СОРТИРОВКА ПО ФИЛЬТРУ "КОМПАНИЯ"
    public void setCompanyCheckbox(String company) {
        String SET_COMPANY_CHECKBOX = String.format(SET_FILTER_VALUE, company);
        CheckBox checkBoxCompany = new CheckBox(driver, By.xpath(SET_COMPANY_CHECKBOX));
        checkBoxCompany.setChecked(true);
        logger.info("Установлен фильтр 'Производитель' - " + company);
    }

    // СОРТИРОВКА ПО ФИЛЬТРУ "ДИАГОНАЛЬ"
    public void openDiagonalAccordion(String accordionName) {
        String SET_DIAGONAL = String.format(SET_FILTER_VALUE, accordionName);
        Accordion diagonalAccordion = new Accordion(driver, By.xpath(SET_DIAGONAL));
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

    public void closeDiagonalAccordion(String accordionName) {
        String SET_DIAGONAL = String.format(SET_FILTER_VALUE, accordionName);
        Accordion diagonalAccordion = new Accordion(driver, By.xpath(SET_DIAGONAL));
        diagonalAccordion.show();
        logger.info("Закрыто подменю фильтра - " + accordionName);
    }

    // СОРТИРОВКА ПО ФИЛЬТРУ "ЧАСТОТА ОБНОВЛЕНИЯ ЭКРАНА"
    public void openScreenRefreshRateAccordion(String accordionName) {
        String OPEN_REFRESH_RATE_ACCORDION = String.format(SET_FILTER_VALUE, accordionName);
        Accordion diagonalAccordion = new Accordion(driver, By.xpath(OPEN_REFRESH_RATE_ACCORDION));
        diagonalAccordion.show();
        logger.info("Открыто подменю фильтра - " + accordionName);
    }

    public void setScreenRefreshRateFilterCheckbox(String refreshValue) {
        String SET_REFRESH_RATE_CHECKBOX = String.format(SET_FILTER_VALUE, refreshValue);
        CheckBox refreshRateCheckbox = new CheckBox(driver, By.xpath(SET_REFRESH_RATE_CHECKBOX));
        refreshRateCheckbox.setChecked(true);
        logger.info("Установлен фильтр 'Частота экрана (Гц)' - " + refreshValue);
    }

    public void closeScreenRefreshRateAccordion(String accordionName) {
        String CLOSE_REFRESH_RATE_ACCORDION = String.format(SET_FILTER_VALUE, accordionName);
        Accordion diagonalAccordion = new Accordion(driver, By.xpath(CLOSE_REFRESH_RATE_ACCORDION));
        diagonalAccordion.show();
        logger.info("Закрыто подменю фильтра - " + accordionName);
    }

    // СОРТИРОВКА ПО ФИЛЬТРУ "ТИП ПОДСВЕТКИ"
    public void openIlluminationTypeAccordion(String accordionName) {
        String OPEN_ILLUMINATION_ACCORDION = String.format(SET_FILTER_VALUE, accordionName);
        Accordion illuminationTypeAccordion = new Accordion(driver, By.xpath(OPEN_ILLUMINATION_ACCORDION));
        illuminationTypeAccordion.show();
        logger.info("Открыто подменю фильтра - " + accordionName);
    }

    public void setIlluminationTypeFilterCheckbox(String illuminationType) {
        String SET_ILLUMINATION_CHECKBOX = String.format(SET_FILTER_VALUE, illuminationType);
        CheckBox illuminationTypeCheckbox = new CheckBox(driver, By.xpath(SET_ILLUMINATION_CHECKBOX));
        illuminationTypeCheckbox.setChecked(true);
        logger.info("Установлен фильтр 'Тип подсветки экрана' - " + illuminationType);
    }

    public void closeIlluminationTypeAccordion(String accordionName) {
        String CLOSE_ILLUMINATION_ACCORDION = String.format(SET_FILTER_VALUE, accordionName);
        Accordion illuminationTypeAccordion = new Accordion(driver, By.xpath(CLOSE_ILLUMINATION_ACCORDION));
        illuminationTypeAccordion.show();
        logger.info("Закрыто подменю фильтра - " + accordionName);
    }

    // ПРИМЕНИТЬ ВСЕ ФИЛЬТРЫ
    public void applyFiltersButtonClick() {
        Button buttonApply = new Button(driver, By.xpath(APPLY_FILTERS_BUTTON));
        buttonApply.click();
        logger.info("Нажата кнопка \"Применить\"");
    }

    // ОТКРЫТЬ ПЕРВЫЙ ПРОДУКТ В СПИСКЕ
    public void firstProductLinkClick(String product) {
        WaitFor.firstProductMustBe(By.xpath(FIRST_PRODUCT_IN_LIST_LINK), product);
        Link linkProduct = new Link(driver, By.xpath(FIRST_PRODUCT_IN_LIST_LINK));
        linkProduct.openInNewWindow();
        logger.info("Нажата ссылка первого продукта в списке");
    }
}
