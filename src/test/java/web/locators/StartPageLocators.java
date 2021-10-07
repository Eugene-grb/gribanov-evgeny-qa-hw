package web.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import web.pages.BasePage;

public class StartPageLocators extends BasePage {

    // КНОПКА "ДА" В АЛЕРТЕ ГОРОДА
    @FindBy(xpath = "//a[contains(@rel, 'nofollow noopener')]")
    @CacheLookup
    public WebElement linkYes;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__root-title' and contains(text(),'ТВ и мультимедиа')]")
    public WebElement multimediaMainCatalogLink;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__second-level' and contains(text(),'Видеоигры')]")
    public WebElement gameSubcategoryLink;

    @FindBy(xpath = "//a[@class='ui-link menu-desktop__popup-link' and contains(text(),'Игры для PlayStation')]")
    public WebElement playStationsSubcategoryLinkPopup;

    public StartPageLocators(WebDriver driver) {
        super(driver);
    }
}
