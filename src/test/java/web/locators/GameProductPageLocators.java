package web.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.pages.BasePage;

public class GameProductPageLocators extends BasePage {

    // Ссылка "Характеристики"
    @FindBy(xpath = "//a[text()=\"Характеристики\"]")
    public WebElement linkCharacteristics;
    // Таблица "Характеристики"
    @FindBy(xpath = "//table")
    public WebElement tableCharacteristics;

    public GameProductPageLocators(WebDriver driver) {
        super(driver);
    }
}
