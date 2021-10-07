package steps;

import lombok.extern.log4j.Log4j2;
import models.valueobjects.*;
import web.helpers.JavaScriptHelper;
import web.pages.TVsCatalogPage;

@Log4j2
public class TVsCatalogPageSteps {

    private final TVsCatalogPage tVsCatalogPage;

    public TVsCatalogPageSteps(TVsCatalogPage tVsCatalogPage) {
        this.tVsCatalogPage = tVsCatalogPage;
        log.info("Открыта страница [Телевизоры / Каталог]");
    }

    // СОРТИРОВАТЬ ПО ЦЕНЕ
    public void sortByExpensive() {
        tVsCatalogPage.openPriceSortingButton();
        tVsCatalogPage.setExpensiveSortButton();
    }

    // СОРТИРОВАТЬ ПО ПРОИЗВОДИТЕЛЮ
    public void filterByCompany(Company company) {
        JavaScriptHelper.scrollBy(0,1200);
        tVsCatalogPage.setCompanyCheckbox(company.getCompany());
    }

    // СОРТИРОВАТЬ ПО "ДИАГОНАЛИ"
    public void filterByDiagonal(String accordionName,MinDiagonal minDiagonal, MaxDiagonal maxDiagonal) {
        JavaScriptHelper.scrollBy(0, 300);
        tVsCatalogPage.openDiagonalAccordion(accordionName);
        tVsCatalogPage.setValueInDiagonalTextFieldInitial(minDiagonal.getDiagonal());
        tVsCatalogPage.setValueInDiagonalTextFieldFinal(maxDiagonal.getDiagonal());
        tVsCatalogPage.closeDiagonalAccordion(accordionName);
    }

    // СОРТИРОВАТЬ ПО "ЧАСТОТЕ ОБНОВЛЕНИЯ"
    public void filterByRefreshRate(String accordionName, RefreshRate refreshRate) {
        JavaScriptHelper.scrollBy(0, 300);
        tVsCatalogPage.openScreenRefreshRateAccordion(accordionName);
        tVsCatalogPage.setScreenRefreshRateFilterCheckbox(refreshRate.getRefreshRate());
        tVsCatalogPage.closeScreenRefreshRateAccordion(accordionName);
    }

    // СОРТИРОВАТЬ ПО "ТИПУ ПОДСВЕТКИ"
    public void filterByIlluminationType(String accordionName, Illumination illumination) {
        JavaScriptHelper.scrollBy(0, 300);
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
        JavaScriptHelper.scrollBy(0, -1200);
        tVsCatalogPage.firstProductLinkClick(product);
    }
}
