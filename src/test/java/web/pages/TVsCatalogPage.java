package web.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.elements.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TVsCatalogPage extends BasePage {

    private static final String SORT_CHEAP_BUTTON = "//a[@class='ui-link ui-link_blue']/descendant-or-self::*[text()='Сначала недорогие']";
    private static final String SORT_BUTTON = "//span[@class='ui-radio__content']/descendant-or-self::*[text()='%s']";
    private static final String APPLY_FILTERS_BUTTON = "//div[@class='apply-filters-float-btn']";
    private static final String FIRST_PRODUCT_IN_LIST_LINK = "//div[@data-id='product']/*[@class='catalog-product__name ui-link ui-link_black'][1]";
    private static final String SET_FILTER_VALUE = "//div[@data-role='filters-container']//span[starts-with(text(),'%s')]";
    private static final String SET_FILTER_REFRESH_VALUE = "//div[@data-role='filters-container']//span[starts-with(text(),'Частота обновления экрана (Гц)')]";


    public TVsCatalogPage(WebDriver driver) {
        super(driver);
    }

    // СОРТИРОВКА ПО ЦЕНЕ
    public void setSortBy(String sortBy) {
        Button sortCheapButton = new Button(By.xpath(SORT_CHEAP_BUTTON));
        sortCheapButton.click();
        log.info("Открыто меню сортировки по цене");

        String SET_SORT = String.format(SORT_BUTTON, sortBy);
        Button sortExpensiveButton = new Button(By.xpath(SET_SORT));
        sortExpensiveButton.click();
        log.info("Установлена сортировка: " + sortBy);
    }

    // СОРТИРОВКА ПО ФИЛЬТРУ "КОМПАНИЯ"
    public void setCompanyCheckbox(String company) {
        String SET_COMPANY_CHECKBOX = String.format(SET_FILTER_VALUE, company);
        CheckBox checkBoxCompany = new CheckBox(By.xpath(SET_COMPANY_CHECKBOX));
        checkBoxCompany.setChecked(true);
        log.info("Установлен фильтр 'Производитель' - " + company);
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

    public void screenRefreshRateAccordion() {
        Accordion diagonalAccordion = new Accordion(By.xpath(SET_FILTER_REFRESH_VALUE));
        diagonalAccordion.show();
        log.info("Открыто/закрыто подменю фильтра - 'Частота обновления экрана(Гц)'");
    }

    // ПРИМЕНИТЬ ВСЕ ФИЛЬТРЫ
    public void applyFiltersButtonClick() {
        Button buttonApply = new Button(By.xpath(APPLY_FILTERS_BUTTON));
        buttonApply.click();
        log.info("Нажата кнопка 'Применить'");
    }

    // ОТКРЫТЬ ПЕРВЫЙ ПРОДУКТ В СПИСКЕ
    public void firstProductLink() {
        Link linkProduct = new Link(By.xpath(FIRST_PRODUCT_IN_LIST_LINK));
        linkProduct.openInNewWindow();
        log.info("Нажата ссылка первого продукта в списке");
    }
}
