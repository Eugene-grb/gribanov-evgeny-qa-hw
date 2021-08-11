public class PageLocators {
    // Локаторы
    String cityConfirmButton =
            "//a[contains(@rel, 'nofollow noopener')]";
    String smartphonesMainCatalogButton =
            "//a[@class='ui-link menu-desktop__root-title' and contains(text(),'Смартфоны и гаджеты')]";
    String samsungSubcategoryButton =
            "//label[@class='ui-checkbox ui-checkbox_list']/descendant-or-self::*[@value='samsung']";
    String ramSubcategoryButton =
            "//*[@class='ui-list-controls ui-collapse ui-collapse_list']/descendant-or-self::*[text()='Объем оперативной памяти']";
    String smartphoneSubcategoryButton =
            "//*[@class='ui-link menu-desktop__second-level']/descendant-or-self::*[text()='Смартфоны']";
    String ram8GbButton =
            "//label[@class='ui-checkbox ui-checkbox_list']/descendant-or-self::*[@value='i2ft']";
    String applyFiltersFloatButton =
            "//div[@class='apply-filters-float-btn']";
    String sortCheapButton =
            "//a[@class='ui-link ui-link_blue']/descendant-or-self::*[text()='Сначала недорогие']";
    String sortExpensiveButton =
            "//span[@class='ui-radio__content']/descendant-or-self::*[text()='Сначала дорогие']";
    String productList =
            "//div[@data-id='product']/*[@class='catalog-product__name ui-link ui-link_black'][1]";
}
