package tests.assertions;

import steps.TVProductPageSteps;
import static com.google.common.truth.Truth.assertWithMessage;

public class SamsungTVsPageAssertions {

    TVProductPageSteps tvProductPageSteps;

    public SamsungTVsPageAssertions(TVProductPageSteps tvProductPageSteps) {
        this.tvProductPageSteps = tvProductPageSteps;
    }

    public void pageTitleEquals(String expected) {
        String actual = tvProductPageSteps.getTitle();
        assertWithMessage("Заголовок не соответствует ожидаемому!")
                .that(expected)
                .contains(actual);
    }

    public void modelNameEquals(String expectedCompany) {
        String actualCompany = tvProductPageSteps.getCompanyValue("Модель");
        assertWithMessage("Модель не соответствует ожидаемой!")
                .that(expectedCompany)
                .contains(expectedCompany.strip());
    }
}

//    String actualIlluminationType = tvProductPageSteps.getIlluminationValue("Тип подсветки экрана");
//    String actualDiagonal = tvProductPageSteps.getDiagonalValue("Диагональ экрана (дюйм)");
//    String actualRefreshRate = tvProductPageSteps.getRefreshRateValue("Частота обновления экрана");