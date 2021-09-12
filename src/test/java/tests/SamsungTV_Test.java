package tests;

import helpers.Screenshots;
import models.TVObject;
import models.TVObjectBuilder;
import models.valueObjects.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Sleeper;
import pages.MainPage;
import pages.TVProductPage;
import pages.TVsCatalogPage;
import steps.MainPageSteps;
import steps.TVProductPageSteps;
import steps.TVsCatalogPageSteps;

import java.time.Duration;

public class SamsungTV_Test extends BaseTest {

    String EXPECTED_COMPANY = "Samsung";
    String EXPECTED_ILLUMINATION_TYPE = "Direct LED";
    int EXPECTED_MAX_DIAGONAL = 80;
    int EXPECTED_MIN_DIAGONAL = 60;
    String EXPECTED_REFRESH_RATE = "120 Гц";
    String EXPECTED_PRODUCT = "Телевизор LED Samsung QE75Q950TSUXRU серый";
    String EXPECTED_PAGE_TITLE =
            "Купить 75\\\" (189 см) Телевизор LED Samsung QE75Q950TSUXRU серый в интернет магазине DNS. Характеристики, цена Samsung QE75Q950TSUXRU | 8165296";


    @Test
    public void productIsSamsungTV() throws InterruptedException {
        // 1. Arrange
        String EXPECTED_PAGE_TITLE = this.EXPECTED_PAGE_TITLE;

        TVObjectBuilder builder = new TVObjectBuilder(
                new Company(this.EXPECTED_COMPANY),
                new MaxDiagonal(this.EXPECTED_MAX_DIAGONAL),
                new Illumination(this.EXPECTED_ILLUMINATION_TYPE),
                new RefreshRate(this.EXPECTED_REFRESH_RATE),
                new MinDiagonal(this.EXPECTED_MIN_DIAGONAL)
        );

        TVObject tvObject = builder.build();

        // 2. Act
        TVProductPageSteps tvProductPageSteps = getProductPage(tvObject);
        // 3. Assert

    }

    public TVProductPageSteps getProductPage(TVObject tvObject) throws InterruptedException {
        // Открыть страницу DNS
        driver.get("https://www.dns-shop.ru/");

        // Стартовая страница
        MainPageSteps mainPageSteps = new MainPageSteps(new MainPage(driver));
        // -- Перейти в каталог "Телевизоры"
        mainPageSteps.clickTVsLink();

        // Страница "Каталог телевизоров"
        TVsCatalogPageSteps tVsCatalogPageSteps = new TVsCatalogPageSteps(new TVsCatalogPage(driver));
        // -- Сделать скриншот страницы
        //Screenshots.MakeAScreenshot("png", "(1)tvPage", driver);
        // -- Установить сортировку "Сначала дорогие"
        //tVsCatalogPageSteps.sortByExpensive();
        // -- Установить фильтр по компании
        tVsCatalogPageSteps.filterByCompany(tvObject.getCompany());
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(8));
        // -- Установить фильтр по диагонали
        tVsCatalogPageSteps.filterByDiagonal(
                "Диагональ экрана (дюйм)",
                tvObject.getMinDiagonal(),
                tvObject.getMaxDiagonal());
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(8));

        // -- Установить фильтр по частоте обновления экрана
        tVsCatalogPageSteps.filterByRefreshRate(
                "Частота обновления экрана (Гц)",
                tvObject.getRefreshRate());


        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(8));
        // -- Установить фильтр по типу подсветки экрана
        tVsCatalogPageSteps.filterByIlluminationType(
                "Тип подсветки экрана",
                tvObject.getIllumination());
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(8));
        // -- Применить фильтры
        tVsCatalogPageSteps.applyFiltersButtonClick();
        // -- Сделать скриншот страницы
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(8));
        Screenshots.MakeAScreenshot("png", "(2)tvPage", driver);
        // -- Нажать на ссылку первого товара в каталоге
        tVsCatalogPageSteps.firstProductLinkClick(EXPECTED_PRODUCT);

        return new TVProductPageSteps(new TVProductPage(driver));
    }

}
