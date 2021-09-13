package tests.assertions;


import org.junit.jupiter.api.Assertions;
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
}
