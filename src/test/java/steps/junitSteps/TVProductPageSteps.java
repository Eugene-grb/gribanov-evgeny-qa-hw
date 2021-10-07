package steps.junitSteps;

import lombok.extern.log4j.Log4j2;
import web.helpers.JavaScriptHelper;
import web.pages.BasePage;
import web.pages.TVProductPage;

@Log4j2
public class TVProductPageSteps {

    private final TVProductPage tvProductPage;

    public TVProductPageSteps(TVProductPage tvProductPage) {
        this.tvProductPage = tvProductPage;
        log.info("Открыта страница [Телевизоры / Продукт]");
    }

    public void specsLinkClick() {
        JavaScriptHelper.scrollBy(0, 300);
        tvProductPage.pressCharacteristicButton();
        JavaScriptHelper.scrollBy(0, 600);
    }

    public String getCompanyValue(String companyColumnName) {
        return tvProductPage.returnRightField(companyColumnName);
    }

    public String getDiagonalValue(String diagonalColumnName) {
        return tvProductPage.returnRightField(diagonalColumnName);
    }

    public String getRefreshRateValue(String refreshRateColumnName) {
        return tvProductPage.returnRightField(refreshRateColumnName);
    }

    public String getIlluminationValue(String illuminationColumnName) {
        return tvProductPage.returnRightField(illuminationColumnName);
    }
}
