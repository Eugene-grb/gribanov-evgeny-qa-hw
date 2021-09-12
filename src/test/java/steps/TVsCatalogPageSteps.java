package steps;

import models.valueObjects.*;
import helpers.JSExecutor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.TVsCatalogPage;

public class TVsCatalogPageSteps {

    private static final Logger logger = LogManager.getLogger(TVsCatalogPageSteps.class);

    private final TVsCatalogPage tVsCatalogPage;

    public TVsCatalogPageSteps(TVsCatalogPage tVsCatalogPage) {
        this.tVsCatalogPage = tVsCatalogPage;
        logger.info("Открыта страница [Телевизоры / Каталог]");
    }

    public void sortByExpensive() {
        tVsCatalogPage.openPriceSortingButton();
        tVsCatalogPage.setExpensiveSortButton();
    }

    public void filterByCompany(Company company) {
        JSExecutor.scrollBy(0,1200);
        tVsCatalogPage.setCompanyCheckbox(company.getCompany());
    }

    public void filterByDiagonal(String accordionName,MinDiagonal minDiagonal, MaxDiagonal maxDiagonal) {
        JSExecutor.scrollBy(0, 300);
        tVsCatalogPage.openDiagonalAccordion(accordionName);
        tVsCatalogPage.setValueInDiagonalTextFieldInitial(minDiagonal.getDiagonal());
        tVsCatalogPage.setValueInDiagonalTextFieldFinal(maxDiagonal.getDiagonal());
    }

    public void filterByRefreshRate(String accordionName, RefreshRate refreshRate) {
        JSExecutor.scrollBy(0, 600);
        tVsCatalogPage.openScreenRefreshRateAccordion(accordionName);
        tVsCatalogPage.setScreenRefreshRateFilterCheckbox(refreshRate.getRefreshRate());
    }

    public void filterByIlluminationType(String accordionName, Illumination illumination) {
        JSExecutor.scrollBy(0, 300);
        tVsCatalogPage.openIlluminationTypeAccordion(accordionName);
        tVsCatalogPage.setIlluminationTypeFilterCheckbox(illumination.getIlluminationType());
    }

    public void applyFiltersButtonClick() {
        JSExecutor.scrollBy(0, 300);
        tVsCatalogPage.applyFiltersButtonClick();
    }

    public void firstProductLinkClick(String product) {
        JSExecutor.scrollBy(0, -500);
        tVsCatalogPage.firstProductLinkClick(product);
    }
}
