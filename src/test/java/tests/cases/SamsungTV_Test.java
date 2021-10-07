package tests.cases;

import web.helpers.ScreenshotHelper;
import models.testobjects.TVObject;
import models.testobjects.TVObjectBuilder;
import models.valueobjects.*;
import org.junit.jupiter.api.Test;
import web.pages.MainPage;
import web.pages.TVProductPage;
import web.pages.TVsCatalogPage;
import steps.junitSteps.MainPageSteps;
import steps.junitSteps.TVProductPageSteps;
import steps.junitSteps.TVsCatalogPageSteps;
import tests.BaseTest;
import tests.assertions.SamsungTV_Assertions;


public class SamsungTV_Test extends BaseTest {

    String EXPECTED_COMPANY = "Samsung";
    String EXPECTED_ILLUMINATION_TYPE = "Direct LED";
    String EXPECTED_MAX_DIAGONAL = "80";
    String EXPECTED_MIN_DIAGONAL = "60";
    String EXPECTED_REFRESH_RATE = "120 Гц";
    String EXPECTED_PRODUCT = "Телевизор LED Samsung QE75Q900TSUXRU черный";
    String EXPECTED_PAGE_TITLE =
            "Купить 75\" (189 см) Телевизор LED Samsung QE75Q900TSUXRU черный в интернет магазине DNS. " +
                    "Характеристики, цена Samsung QE75Q900TSUXRU | 1669169";

    // Создать объект
    TVObjectBuilder builder = new TVObjectBuilder(
            new Company(this.EXPECTED_COMPANY),
            new MaxDiagonal(this.EXPECTED_MAX_DIAGONAL),
            new Illumination(this.EXPECTED_ILLUMINATION_TYPE),
            new RefreshRate(this.EXPECTED_REFRESH_RATE),
            new MinDiagonal(this.EXPECTED_MIN_DIAGONAL)
    );


    @Test
    public void checkPageTitle() {
        // 1. Arrange
        TVObject tvObject = builder.build();

        // 2. Act
        TVProductPageSteps newTvProductPage = openPageTest(tvObject);
        SamsungTV_Assertions pageAssert = new SamsungTV_Assertions(newTvProductPage);
        ScreenshotHelper.takeScreenshot("ProductPage_Product", "temp");

        // 3. Assert
        pageAssert.pageTitleEquals(EXPECTED_PAGE_TITLE);
    }


    @Test
    public void checkProductSpecs() {
        // 1. Arrange
        TVObject tvObject = builder.build();

        // 2. Act
        TVProductPageSteps tvProductPageSteps = openPageTest(tvObject);
        tvProductPageSteps.specsLinkClick();
        ScreenshotHelper.takeScreenshot("ProductPage_Characteristics", "temp");

        SamsungTV_Assertions pageAssert = new SamsungTV_Assertions(tvProductPageSteps);

        // 3. Assert
        pageAssert.modelNameEquals(EXPECTED_COMPANY);
        pageAssert.illuminationTypeEquals(EXPECTED_ILLUMINATION_TYPE);
        pageAssert.diagonalEquals(EXPECTED_MAX_DIAGONAL, EXPECTED_MIN_DIAGONAL);
        pageAssert.refreshRateEquals(EXPECTED_REFRESH_RATE);
    }

    public TVProductPageSteps openPageTest(TVObject tvObject) {

        // Открыть страницу DNS
        driver.get("https://www.dns-shop.ru/");

        // Стартовая страница
        MainPageSteps mainPageSteps = new MainPageSteps(new MainPage(driver));
        // -- Перейти в каталог "Телевизоры"
        mainPageSteps.clickTVsLink();

        // Страница "Каталог телевизоров"
        TVsCatalogPageSteps tVsCatalogPageSteps = new TVsCatalogPageSteps(new TVsCatalogPage(driver));
        // -- Сделать скриншот страницы
        ScreenshotHelper.takeScreenshot("TvCatalog_Original", "temp");

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
        ScreenshotHelper.takeScreenshot("TvCatalog_WithFilters", "temp");

        // -- Нажать на ссылку первого товара в каталоге
        tVsCatalogPageSteps.firstProductLinkClick(EXPECTED_PRODUCT);

        // Страница "Продукт"
        TVProductPageSteps tvProductPageSteps = new TVProductPageSteps(new TVProductPage(driver));

        return new TVProductPageSteps(new TVProductPage(driver));
    }
}
