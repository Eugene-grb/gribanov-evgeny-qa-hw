package steps.junitSteps;

import lombok.extern.log4j.Log4j2;
import web.pages.MainPage;

@Log4j2
public class MainPageSteps {

    private final MainPage mainPage;

    public MainPageSteps(MainPage mainPage) {
        this.mainPage = mainPage;
        log.info("Открыта страница [Стартовая страница DNS]");
    }

    public void clickTVsLink() {
        mainPage.closeCityConfirmAlert();
        mainPage.linkTVsMainCatalogButtonMove();
        mainPage.linkTVsSubcatalogClick();
    }

}
