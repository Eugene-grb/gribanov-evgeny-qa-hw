package tests.assertions;

import static org.assertj.core.api.Assertions.assertThat;
import steps.TVProductPageSteps;

public class SamsungTVsPageAssertions {

    TVProductPageSteps tvProductPageSteps;

    public SamsungTVsPageAssertions(TVProductPageSteps tvProductPageSteps) {
        this.tvProductPageSteps = tvProductPageSteps;
    }

    public void pageTitleEquals(String expected) {
        String actual = tvProductPageSteps.getTitle();
        assertThat(actual.strip()).as("Заголовок не соответствует ожидаемому!")
                .contains(expected);
    }

    public void modelNameEquals(String expected) {
        String actualCompany = tvProductPageSteps.getCompanyValue("Модель");
        assertThat(actualCompany.strip()).as("Модель не соответствует ожидаемой!")
                .contains(expected);
    }

    public void illuminationTypeEquals(String expected) {
        String actualIlluminationType = tvProductPageSteps.getIlluminationValue("Тип подсветки экрана");
        assertThat(actualIlluminationType.strip()).as("Тип подсветки не соответствует ожидаемой!")
                .contains(expected);
    }

    public void refreshRateEquals(String expected) {
        String actualRefreshRate = tvProductPageSteps.getRefreshRateValue("Частота обновления экрана");
        assertThat(actualRefreshRate.strip()).as("Частота обновления не соответствует ожидаемой!")
                .contains(expected);
    }

    public void diagonalEquals(String expectedMax, String expectedMin) {
        String actualDiagonal = tvProductPageSteps.getDiagonalValue("Диагональ экрана (дюйм)");
        assertThat(actualDiagonal).as("Диагональ экрана выходит за пределы заданных значений")
                .isGreaterThanOrEqualTo(expectedMin)
                .isLessThanOrEqualTo(expectedMax);
    }
}
