package web.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.pages.BasePage;

public class PlayStationsGameCatalogLocators extends BasePage  {

    // Шапка
    @FindBy(xpath = "//header")
    public WebElement mainBlock;

    // Аккордеон "Сортировка"
    @FindBy(xpath = "//span[contains(text(), 'Сортировка:')]/following::a")
    public WebElement accordeonSort;

    // Блок с переключателями "Сортировка"
    @FindBy(xpath = "(//div[@class='top-filter__radio-list ui-radio top-filter__popover'])[1]")
    public WebElement divSort;

    // АККОРДИОН ПЛАТФОРМА
    @FindBy(xpath = "//div[@class='ui-list-controls ui-collapse ui-collapse_list']//span[contains(text(), 'Платформа')]")
    public WebElement accordionPlatform;

    // БЛОК С ЧЕКБОКСАМИ ПЛАТФОРМА
    @FindBy(xpath = "//span[text()='Платформа']/parent::a/following-sibling::div//div[@class='ui-checkbox-group ui-checkbox-group_list']")
    public WebElement divPlatform;

    // Кнопка "Применить"
    @FindBy(xpath = "//button[contains(text(), 'Применить')]")
    public WebElement buttonApply;

    // Аккордеон "Год релиза"
    @FindBy(xpath = "//div[@class='ui-list-controls ui-collapse ui-collapse_list']//span[contains(text(), 'Год релиза')]")
    public WebElement releaseYearAccordion;

    // Блок с переключателями "Год релиза"
    @FindBy(xpath = "//span[text()='Год релиза']/parent::a/following-sibling::div//div[@class='ui-checkbox-group ui-checkbox-group_list']")
    public WebElement divReleaseYear;

    @FindBy(xpath = "//div[@class='ui-input-search ui-input-search_list']/descendant::*[@placeholder='Поиск']")
    public WebElement searchReleaseYearPlaceholder;

    // аккордеон тип упаковки
    @FindBy(xpath = "//div[@class='ui-list-controls ui-collapse ui-collapse_list']//span[contains(text(), 'Тип упаковки')]")
    public WebElement gameBoxAccordion;

    // БЛОК С ЧЕКБОКСАМИ ТИП УПАКОВКИ
    @FindBy(xpath = "//span[text()='Тип упаковки']/parent::a/following-sibling::div//div[@class='ui-checkbox-group ui-checkbox-group_list']")
    public WebElement divGameBox;

    // Ссылка на первый продукт в списке
    @FindBy(xpath = "(//a[contains(@class, 'catalog-product__name')])[1]")
    public WebElement linkFirstProduct;

    public PlayStationsGameCatalogLocators(WebDriver driver) {
        super(driver);
    }
}
