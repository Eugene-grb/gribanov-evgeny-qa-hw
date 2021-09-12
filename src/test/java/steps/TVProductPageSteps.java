package steps;

import helpers.JSExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.TVProductPage;

public class TVProductPageSteps {

    private static final Logger logger = LogManager.getLogger(TVProductPageSteps.class);

    private final TVProductPage tvProductPage;

    public TVProductPageSteps(TVProductPage tvProductPage) {
        this.tvProductPage = tvProductPage;
        logger.info("Открыта страница [Телевизоры / Продукт]");
    }

    public void getTitle() {
        tvProductPage.getPageTitle();
    }

    public void specsLinkClick() {
        JSExecutor.scrollBy(0, 300);
        tvProductPage.pressCharacteristicButton();
    }

    public String getCompanyValue(String companyColumnName) {
        return tvProductPage.returnCompanyField(companyColumnName);
    }

    public String getDiagonalValue(String diagonalColumnName) {
        return tvProductPage.returnDiagonalField(diagonalColumnName);
    }

    public String getRefreshRateValue(String refreshRateColumnName) {
        return tvProductPage.returnRefreshField(refreshRateColumnName);
    }

    public String getIlluminationValue(String illuminationColumnName) {
        return tvProductPage.returnIlluminationField(illuminationColumnName);
    }
}
