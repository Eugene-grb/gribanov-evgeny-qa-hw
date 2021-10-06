//package tests.assertions;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import steps.щдв.TVProductPageSteps;
//
//public class SamsungTVsPageAssertions {
//
//    TVProductPageSteps tvProductPageSteps;
//    private static final Logger logger = LogManager.getLogger(SamsungTVsPageAssertions.class);
//
//    public SamsungTVsPageAssertions(TVProductPageSteps tvProductPageSteps) {
//        this.tvProductPageSteps = tvProductPageSteps;
//    }
//
//    public void pageTitleEquals(String expected) {
//        String actual = tvProductPageSteps.getTitle();
//        assertThat(actual.strip()).as("Заголовок не соответствует ожидаемому!")
//                .contains(expected);
//        logger.info(":: ASSERTION 'Заголовок страницы' содержит: " + actual + ", ожидается: " + expected);
//    }
//
//    public void modelNameEquals(String expected) {
//        String actualCompany = tvProductPageSteps.getCompanyValue("Модель");
//        assertThat(actualCompany.strip()).as("Модель не соответствует ожидаемой!")
//                .contains(expected);
//        logger.info(":: ASSERTION 'Модель продукта' содержит: " + actualCompany + ", ожидается: " + expected);
//    }
//
//    public void illuminationTypeEquals(String expected) {
//        String actualIlluminationType = tvProductPageSteps.getIlluminationValue("Тип подсветки экрана");
//        assertThat(actualIlluminationType.strip()).as("Тип подсветки не соответствует ожидаемой!")
//                .contains(expected);
//        logger.info(":: ASSERTION 'Тип подсветки' содержит: " + actualIlluminationType + ", ожидается: " + expected);
//    }
//
//    public void refreshRateEquals(String expected) {
//        String actualRefreshRate = tvProductPageSteps.getRefreshRateValue("Частота обновления экрана");
//        assertThat(actualRefreshRate.strip()).as("Частота обновления не соответствует ожидаемой!")
//                .contains(expected);
//        logger.info(":: ASSERTION 'Частота обновления экрана' содержит: " + actualRefreshRate + ", ожидается: " + expected);
//    }
//
//    public void diagonalEquals(String expectedMax, String expectedMin) {
//        String actualDiagonal = tvProductPageSteps.getDiagonalValue("Диагональ экрана (дюйм)");
//        assertThat(actualDiagonal).as("Диагональ экрана выходит за пределы заданных значений")
//                .isGreaterThanOrEqualTo(expectedMin)
//                .isLessThanOrEqualTo(expectedMax);
//        logger.info(":: ASSERTION 'Диагональ (дюйм)' содержит: " + actualDiagonal + ", ожидается: " + expectedMin + " - " + expectedMax);
//    }
//}
