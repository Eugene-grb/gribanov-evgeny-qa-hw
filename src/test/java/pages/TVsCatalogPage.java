package pages;

import org.openqa.selenium.WebDriver;

public class TVsCatalogPage extends BasePage {

    private static final String SORT_CHEAP_BUTTON = "//a[@class='ui-link ui-link_blue']/descendant-or-self::*[text()='Сначала недорогие']";
    private static final String SORT_EXPENSIVE_BUTTON = "//span[@class='ui-radio__content']/descendant-or-self::*[text()='Сначала дорогие']";
    private static final String APPLY_FILTERS_BUTTON = "//div[@class='apply-filters-float-btn']";
    private static final String FIRST_PRODUCT_IN_LIST_LINK = "//div[@data-id='product']/*[@class='catalog-product__name ui-link ui-link_black'][1]";
    private static String MANUFACTURER_CHECKBOX = "//div[@data-id='brand']/descendant-or-self::*[@value='%s']";
    private static String DIAGONAL_FILTER = "//div[@data-id='fr[p2]']//span[starts-with(text(),'%s')]";
    private static String SCREEN_REFRESH_RATE_FILTER = "//div[@data-id='f[adg]']//span[starts-with(text(),'%s')]";
    private static String ILLUMINATION_TYPE_FILTER = "//div[@data-id='f[rh2]']//span[starts-with(text(),'%s')]";
    private static String FILTERS_INPUT_FIELD = "//div[@data-id='fr[p2]']/descendant-or-self::*[@placeholder='%s']";


    public TVsCatalogPage(WebDriver driver) {
        super(driver);
    }


}
