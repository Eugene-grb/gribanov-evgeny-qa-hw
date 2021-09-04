package pages;

import org.openqa.selenium.WebDriver;

public class TVsCatalogPage extends BasePage {

    private static final String SORT_CHEAP_BUTTON = "//a[@class='ui-link ui-link_blue']/descendant-or-self::*[text()='Сначала недорогие']";
    private static final String SORT_EXPENSIVE_BUTTON = "//span[@class='ui-radio__content']/descendant-or-self::*[text()='Сначала дорогие']";
    private static final String MANUFACTURER_SAMSUNG_CHECKBOX = "//label[@class='ui-checkbox ui-checkbox_list']/descendant-or-self::*[@value='samsung']";
    private static final String DIAGONAL_ACCORDION = "//div[@data-id='fr[p2]']//span[contains(text(),'Диагональ экрана (дюйм)')]";
    private static final String SCREEN_REFRESH_RATE_ACCORDION = "//div[@data-id='f[adg]']//span[contains(text(),'Частота обновления экрана (Гц)')]";
    private static final String SCREEN_REFRESH_120Gz_CHECKBOX = "//div[@data-id='f[adg]']//span[contains(text(),'120 Гц  ')]";
    private static final String FILTERS_INPUT_FIELD = "//input[@class='ui-input-small__input ui-input-small__input_list']/descendant-or-self::*[@placeholder='%s']";



    public TVsCatalogPage(WebDriver driver) {
        super(driver);
    }
}
