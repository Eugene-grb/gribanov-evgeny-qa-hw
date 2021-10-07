package web.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import web.elements.Link;
import web.elements.Table;
import web.helpers.WaitHelper;
import web.locators.GameProductPageLocators;

public class GameProductPage extends BasePage {

    private GameProductPageLocators gameProductPageLocators;

    public GameProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this.gameProductPageLocators);
    }

    // Ссылка "Характеристики"
    public Link linkCharacteristics() {
        WaitHelper.visibilityOfElement(gameProductPageLocators.linkCharacteristics);
        return new Link(gameProductPageLocators.linkCharacteristics);
    }
    // Таблица "Характеристики"
    public Table tableCharacteristics() {
        WaitHelper.visibilityOfElement(gameProductPageLocators.tableCharacteristics);
        return new Table(gameProductPageLocators.tableCharacteristics);
    }
}
