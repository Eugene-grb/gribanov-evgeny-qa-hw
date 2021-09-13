package tests;

import helpers.Screenshots;
import models.TVObject;
import models.TVObjectBuilder;
import models.valueObjects.*;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.TVProductPage;
import pages.TVsCatalogPage;
import steps.MainPageSteps;
import steps.TVProductPageSteps;
import steps.TVsCatalogPageSteps;
import tests.assertions.SamsungTVsPageAssertions;

import java.time.Duration;

public class SamsungTV_Test extends BaseTest {

    String EXPECTED_COMPANY = "Samsung";
    String EXPECTED_ILLUMINATION_TYPE = "Direct LED";
    int EXPECTED_MAX_DIAGONAL = 80;
    int EXPECTED_MIN_DIAGONAL = 60;
    String EXPECTED_REFRESH_RATE = "120 Гц";
    String EXPECTED_PRODUCT = "Телевизор LED Samsung QE75Q950TSUXRU серый";
    String EXPECTED_PAGE_TITLE =
            "Купить 75\" (189 см) Телевизор LED Samsung QE75Q950TSUXRU серый в интернет магазине DNS. " +
                    "Характеристики, цена Samsung QE75Q950TSUXRU | 8165296";


    @Test
    public void productIsSamsungTV() {
        // 1. Arrange
        TVObjectBuilder builder = new TVObjectBuilder(
                new Company(this.EXPECTED_COMPANY),
                new MaxDiagonal(this.EXPECTED_MAX_DIAGONAL),
                new Illumination(this.EXPECTED_ILLUMINATION_TYPE),
                new RefreshRate(this.EXPECTED_REFRESH_RATE),
                new MinDiagonal(this.EXPECTED_MIN_DIAGONAL)
        ); TVObject tvObject = builder.build();

        // 2. Act
        TVProductPageSteps newTvProductPage = getProductPage(tvObject);

        // 3. Assert
        SamsungTVsPageAssertions pageTitleAssert = new SamsungTVsPageAssertions(newTvProductPage);
        pageTitleAssert.pageTitleEquals(EXPECTED_PAGE_TITLE);

    }

    public TVProductPageSteps getProductPage(TVObject tvObject) {
        // Открыть страницу DNS
        driver.get("https://www.dns-shop.ru/");

        // Стартовая страница
        MainPageSteps mainPageSteps = new MainPageSteps(new MainPage(driver));
        // -- Перейти в каталог "Телевизоры"
        mainPageSteps.clickTVsLink();

        // Страница "Каталог телевизоров"
        TVsCatalogPageSteps tVsCatalogPageSteps = new TVsCatalogPageSteps(new TVsCatalogPage(driver));
        // -- Сделать скриншот страницы
        Screenshots.takeScreenshot("TvCatalog_Original", "temp", driver);

        // -- Установить сортировку "Сначала дорогие"
        tVsCatalogPageSteps.sortByExpensive();

        // -- Установить фильтр по компании
        tVsCatalogPageSteps.filterByCompany(tvObject.getCompany());

        // -- Установить фильтр по диагонали
        tVsCatalogPageSteps.filterByDiagonal(
                "Диагональ экрана (дюйм)",
                tvObject.getMinDiagonal(),
                tvObject.getMaxDiagonal());

        // -- Установить фильтр по частоте обновления экрана
        tVsCatalogPageSteps.filterByRefreshRate(
                "Частота обновления экрана (Гц)",
                tvObject.getRefreshRate());

        // -- Установить фильтр по типу подсветки экрана
        tVsCatalogPageSteps.filterByIlluminationType(
                "Тип подсветки экрана",
                tvObject.getIllumination());

        // -- Применить фильтры
        tVsCatalogPageSteps.applyFiltersButtonClick();

        // -- Сделать скриншот страницы
        Screenshots.takeScreenshot("TvCatalog_WithFilters", "temp", driver);

        // -- Нажать на ссылку первого товара в каталоге
        tVsCatalogPageSteps.firstProductLinkClick(EXPECTED_PRODUCT);

        return new TVProductPageSteps(new TVProductPage(driver));
    }

}
