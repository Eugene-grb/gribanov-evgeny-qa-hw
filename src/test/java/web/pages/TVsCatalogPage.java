package web.pages;

import lombok.extern.log4j.Log4j2;
import web.elements.*;
import web.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TVsCatalogPage extends BasePage {

    private static final String SORT_CHEAP_BUTTON = "//a[@class='ui-link ui-link_blue']/descendant-or-self::*[text()='Сначала недорогие']";
    private static final String SORT_EXPENSIVE_BUTTON = "//span[@class='ui-radio__content']/descendant-or-self::*[text()='Сначала дорогие']";
    private static final String APPLY_FILTERS_BUTTON = "//div[@class='apply-filters-float-btn']";
    private static final String FIRST_PRODUCT_IN_LIST_LINK = "//div[@data-id='product']/*[@class='catalog-product__name ui-link ui-link_black'][1]";
    private static final String INITIAL_VALUE_DIAGONAL_FIELD = "//div[@data-id='fr[p2]']/descendant-or-self::*[@placeholder='от 22']";
    private static final String FINAL_VALUE_DIAGONAL_FIELD = "//div[@data-id='fr[p2]']/descendant-or-self::*[@placeholder='до 88']";
    private static final String SET_FILTER_VALUE = "//div[@data-role='filters-container']//span[starts-with(text(),'%s')]";


    public TVsCatalogPage(WebDriver driver) {
        super(driver);
    }

    // СОРТИРОВКА ПО ЦЕНЕ
    public void openPriceSortingButton() {
        Button sortCheapButton = new Button(By.xpath(SORT_CHEAP_BUTTON));
        sortCheapButton.click();
        log.info("Открыто меню сортировки по цене");
    }

    public void setExpensiveSortButton() {
        Button sortExpensiveButton = new Button(By.xpath(SORT_EXPENSIVE_BUTTON));
        sortExpensiveButton.click();
        log.info("Установлена сортировка 'сначала дорогие'");
    }

    // СОРТИРОВКА ПО ФИЛЬТРУ "КОМПАНИЯ"
    public void setCompanyCheckbox(String company) {
        String SET_COMPANY_CHECKBOX = String.format(SET_FILTER_VALUE, company);
        CheckBox checkBoxCompany = new CheckBox(By.xpath(SET_COMPANY_CHECKBOX));
        checkBoxCompany.setChecked(true);
        log.info("Установлен фильтр 'Производитель' - " + company);
    }

    // СОРТИРОВКА ПО ФИЛЬТРУ "ДИАГОНАЛЬ"
    public void openDiagonalAccordion(String accordionName) {
        String SET_DIAGONAL = String.format(SET_FILTER_VALUE, accordionName);
        Accordion diagonalAccordion = new Accordion(By.xpath(SET_DIAGONAL));
        diagonalAccordion.show();
        log.info("Открыто подменю фильтра - " + accordionName);
    }

    public void setValueInDiagonalTextFieldInitial(String initialValue) {
        TextBox initialValueTextBox = new TextBox(By.xpath(INITIAL_VALUE_DIAGONAL_FIELD));
        initialValueTextBox.click();
        initialValueTextBox.setValue(initialValue);
        log.info("Установлено начальное значение фильтра 'Диагональ экрана' - " + initialValue);
    }

    public void setValueInDiagonalTextFieldFinal(String finalValue) {
        TextBox finalValueTextBox = new TextBox(By.xpath(FINAL_VALUE_DIAGONAL_FIELD));
        finalValueTextBox.click();
        finalValueTextBox.setValue(finalValue);
        log.info("Установлено конечное значение фильтра 'Диагональ экрана' - " + finalValue);
    }

    public void closeDiagonalAccordion(String accordionName) {
        String SET_DIAGONAL = String.format(SET_FILTER_VALUE, accordionName);
        Accordion diagonalAccordion = new Accordion(By.xpath(SET_DIAGONAL));
        diagonalAccordion.show();
        log.info("Закрыто подменю фильтра - " + accordionName);
    }

    // СОРТИРОВКА ПО ФИЛЬТРУ "ЧАСТОТА ОБНОВЛЕНИЯ ЭКРАНА"
    public void openScreenRefreshRateAccordion(String accordionName) {
        String OPEN_REFRESH_RATE_ACCORDION = String.format(SET_FILTER_VALUE, accordionName);
        Accordion diagonalAccordion = new Accordion(By.xpath(OPEN_REFRESH_RATE_ACCORDION));
        diagonalAccordion.show();
        log.info("Открыто подменю фильтра - " + accordionName);
    }

    public void setScreenRefreshRateFilterCheckbox(String refreshValue) {
        String SET_REFRESH_RATE_CHECKBOX = String.format(SET_FILTER_VALUE, refreshValue);
        CheckBox refreshRateCheckbox = new CheckBox(By.xpath(SET_REFRESH_RATE_CHECKBOX));
        refreshRateCheckbox.setChecked(true);
        log.info("Установлен фильтр 'Частота экрана (Гц)' - " + refreshValue);
    }

    public void closeScreenRefreshRateAccordion(String accordionName) {
        String CLOSE_REFRESH_RATE_ACCORDION = String.format(SET_FILTER_VALUE, accordionName);
        Accordion diagonalAccordion = new Accordion(By.xpath(CLOSE_REFRESH_RATE_ACCORDION));
        diagonalAccordion.show();
        log.info("Закрыто подменю фильтра - " + accordionName);
    }

    // СОРТИРОВКА ПО ФИЛЬТРУ "ТИП ПОДСВЕТКИ"
    public void openIlluminationTypeAccordion(String accordionName) {
        String OPEN_ILLUMINATION_ACCORDION = String.format(SET_FILTER_VALUE, accordionName);
        Accordion illuminationTypeAccordion = new Accordion(By.xpath(OPEN_ILLUMINATION_ACCORDION));
        illuminationTypeAccordion.show();
        log.info("Открыто подменю фильтра - " + accordionName);
    }

    public void setIlluminationTypeFilterCheckbox(String illuminationType) {
        String SET_ILLUMINATION_CHECKBOX = String.format(SET_FILTER_VALUE, illuminationType);
        CheckBox illuminationTypeCheckbox = new CheckBox(By.xpath(SET_ILLUMINATION_CHECKBOX));
        illuminationTypeCheckbox.setChecked(true);
        log.info("Установлен фильтр 'Тип подсветки экрана' - " + illuminationType);
    }

    public void closeIlluminationTypeAccordion(String accordionName) {
        String CLOSE_ILLUMINATION_ACCORDION = String.format(SET_FILTER_VALUE, accordionName);
        Accordion illuminationTypeAccordion = new Accordion(By.xpath(CLOSE_ILLUMINATION_ACCORDION));
        illuminationTypeAccordion.show();
        log.info("Закрыто подменю фильтра - " + accordionName);
    }

    // ПРИМЕНИТЬ ВСЕ ФИЛЬТРЫ
    public void applyFiltersButtonClick() {
        Button buttonApply = new Button(By.xpath(APPLY_FILTERS_BUTTON));
        buttonApply.click();
        log.info("Нажата кнопка \"Применить\"");
    }

    // ОТКРЫТЬ ПЕРВЫЙ ПРОДУКТ В СПИСКЕ
    public void firstProductLinkClick(String product) {
        WaitHelper.firstProductMustBe(By.xpath(FIRST_PRODUCT_IN_LIST_LINK), product);
        Link linkProduct = new Link(By.xpath(FIRST_PRODUCT_IN_LIST_LINK));
        linkProduct.openInNewWindow();
        log.info("Нажата ссылка первого продукта в списке");
    }
}
