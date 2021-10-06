package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;
import web.locators.StartPageLocators;

public class StartPage extends BasePage {

    // СТРАНИЦА С ЛОКАТОРАМИ
    public StartPageLocators startPageLocators;

    public StartPage(WebDriver driver) {
        super(driver);
    PageFactory.initElements(driver, this.startPageLocators);
    }

    // ВЕРНУТЬ ОБЕРНУТЫЕ ВЕБЭЛЕМЕНТЫ
    public Link linkYes() {
        return new Link(startPageLocators.linkYes);
    }

    public Link multimediaMainCatalogLink() {
        return new Link(startPageLocators.multimediaMainCatalogLink);
    }

    public Link playStationsSubcategoryLink() {
        return new Link(startPageLocators.playStationsSubcategoryLink);
    }

    public  Link playStationsSubcategoryLinkPopup() {
        return new Link(startPageLocators.playStationsSubcategoryLinkPopup);
    }
}
