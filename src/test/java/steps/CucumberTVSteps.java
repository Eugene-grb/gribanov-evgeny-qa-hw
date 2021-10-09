package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import lombok.extern.log4j.Log4j2;
import web.driver.WebDriverFactory;
import web.helpers.JavaScriptHelper;
import web.pages.BasePage;
import web.pages.MainPage;
import web.pages.TVProductPage;
import web.pages.TVsCatalogPage;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

@Log4j2
public class CucumberTVSteps {

    MainPage mainPage;
    TVsCatalogPage tVsCatalogPage;
    TVProductPage tvProductPage;

    @Дано("Открыта Главная страница ДНС")
    public void startDriverAndOpenStartPage() {
        // init pages
        mainPage = new MainPage(WebDriverFactory.getCurrentDriver());
        tVsCatalogPage = new TVsCatalogPage(WebDriverFactory.getCurrentDriver());
        tvProductPage = new TVProductPage(WebDriverFactory.getCurrentDriver());
        // run driver
        WebDriverFactory.getCurrentDriver().get("https://www.dns-shop.ru/");
        log.info("Открыта Стартовая страница сайта DNS");
    }

    @И("Выполнен переход на страницу Телевизоры")
    public void openTvCatalogPage() {
        mainPage.closeCityConfirmAlert();
        mainPage.linkTVsMainCatalogButtonMove();
        mainPage.linkTVsSubcatalogClick();
    }

    @Тогда("Проверить: В заголовке страницы отображается текст Телевизоры")
    public void assertTitle() {
        log.info("Проверка заголовка страницы");
        assertThat(BasePage.getPageTitle())
                .as("Заголовок не соответствует ожидаемому!")
                .contains("Телевизоры");
    }

    @Дано("Установлена сортировка {string}")
    public void setSortBy(String sortBy) {
        tVsCatalogPage.setSortBy(sortBy);
    }

    @И("В фильтре {string} выбрано значение {string}")
    public void setFilterBy(String filterBy, String value) {
        JavaScriptHelper.scrollBy(0,400);
        switch (filterBy) {
            case "Производитель":
                tVsCatalogPage.setCompanyCheckbox(value);
                break;
            case "Частота обновления экрана (Гц)":
                tVsCatalogPage.openScreenRefreshRateAccordion(filterBy);
                tVsCatalogPage.setScreenRefreshRateFilterCheckbox(value);
                tVsCatalogPage.closeScreenRefreshRateAccordion(filterBy);
                break;
        }
        log.info("В фильтре " + filterBy + " выбрано значение " + value);
    }

    @Когда("Применены выбранные фильтры")
    public void applyFilters() {
        JavaScriptHelper.scrollBy(0,400);
        tVsCatalogPage.applyFiltersButtonClick();
        log.info("Применены выбранные фильтры");
    }

    @И("Выполнен переход на страницу первого товара из списка")
    public void selectFirstTv() {
        JavaScriptHelper.scrollBy(0, -1200);
        tVsCatalogPage.firstProductLink();
    }

    @Тогда("Проверить: В заголовке страницы отображается текст {string}")
    public void assertTitleProduct(String company) {
        log.info("Проверка заголовка страницы");
        assertThat(BasePage.getPageTitle())
                .as("Заголовок не соответствует ожидаемому!")
                .contains(company);
    }

    @И("Установлены фильтры из таблицы с одной колонкой")
    public void setFiltersFromTable1(List<String> filters) {

    }

    @И("Установлены фильтры из таблицы с двумя колонками")
    public void setFiltersFromTable2(Map<String, String> filters) {

    }

    @Дано("Установлена сортировка и фильтры из таблицы с тремя колонками")
    public void setFiltersAndSortFromTable3(DataTable dataTable) {

    }
}
