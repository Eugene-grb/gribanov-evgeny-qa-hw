package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.MainPage;

public class MainPageSteps {

    private static Logger logger = LogManager.getLogger(MainPageSteps.class);

    private MainPage mainPage;

    public MainPageSteps(MainPage mainPage) {
        this.mainPage = mainPage;
        logger.info("Открыта страница [Стартовая страница DNS]");
    }

    public void clickTVsLink() {
        mainPage.closeCityConfirmAlert();
        mainPage.linkTVsMainCatalogButtonMove();
        mainPage.linkTVsSubcatalogClick();
    }

}
