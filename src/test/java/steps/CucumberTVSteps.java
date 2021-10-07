package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;

import java.util.List;
import java.util.Map;

public class CucumberTVSteps {

    @Дано("Открыта Главная страница ДНС")
    public void startDriverAndOpenStartPage() {

    }

    @И("Выполнен переход на страницу Телевизоры")
    public void openTvCatalogPage() {

    }

    @Тогда("Проверить: В заголовке страницы отображается текст Телевизоры")
    public void assertTitle() {

    }

    @Дано("Установлена сортировка {string}")
    public void setSortBy(String sortBy) {

    }

    @И("В фильтре {string} выбрано значение {string}")
    public void setFilterBy(String filterBy, String value) {

    }

    @Когда("Применены выбранные фильтры")
    public void applyFilters() {

    }

    @И("Выполнен переход на страницу первого товара из списка")
    public void selectFirstTv() {

    }

    @Тогда("Проверить: В заголовке страницы отображается текст {string}")
    public void assertTitleProduct(String company) {

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
