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

    // СОРТИРОВАТЬ ПО ЦЕНЕ
    public void sortByExpensive() {
        tVsCatalogPage.openPriceSortingButton();
        tVsCatalogPage.setExpensiveSortButton();
    }

    // СОРТИРОВАТЬ ПО ПРОИЗВОДИТЕЛЮ
    public void filterByCompany(Company company) {
        JSExecutor.scrollBy(0,1200);
        tVsCatalogPage.setCompanyCheckbox(company.getCompany());
    }

    // СОРТИРОВАТЬ ПО "ДИАГОНАЛИ"
    public void filterByDiagonal(String accordionName,MinDiagonal minDiagonal, MaxDiagonal maxDiagonal) {
        JSExecutor.scrollBy(0, 300);
        tVsCatalogPage.openDiagonalAccordion(accordionName);
        tVsCatalogPage.setValueInDiagonalTextFieldInitial(minDiagonal.getDiagonal());
        tVsCatalogPage.setValueInDiagonalTextFieldFinal(maxDiagonal.getDiagonal());
        tVsCatalogPage.closeDiagonalAccordion(accordionName);
    }

    // СОРТИРОВАТЬ ПО "ЧАСТОТЕ ОБНОВЛЕНИЯ"
    public void filterByRefreshRate(String accordionName, RefreshRate refreshRate) {
        JSExecutor.scrollBy(0, 300);
        tVsCatalogPage.openScreenRefreshRateAccordion(accordionName);
        tVsCatalogPage.setScreenRefreshRateFilterCheckbox(refreshRate.getRefreshRate());
        tVsCatalogPage.closeScreenRefreshRateAccordion(accordionName);
    }

    // СОРТИРОВАТЬ ПО "ТИПУ ПОДСВЕТКИ"
    public void filterByIlluminationType(String accordionName, Illumination illumination) {
        JSExecutor.scrollBy(0, 300);
        tVsCatalogPage.openIlluminationTypeAccordion(accordionName);
        tVsCatalogPage.setIlluminationTypeFilterCheckbox(illumination.getIlluminationType());
        tVsCatalogPage.closeIlluminationTypeAccordion(accordionName);
    }

    // ПРИМЕНИТЬ ФИЛЬТРЫ
    public void applyFiltersButtonClick() {
        tVsCatalogPage.applyFiltersButtonClick();
    }

    // ОТРЫТЬ ПЕРВЫЙ ПРОДУКТ В СПИСКЕ
    public void firstProductLinkClick(String product) {
        JSExecutor.scrollBy(0, -1200);
        tVsCatalogPage.firstProductLinkClick(product);
    }
}
