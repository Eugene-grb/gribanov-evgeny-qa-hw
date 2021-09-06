package pages;

import helpers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TVProductPage extends BasePage {

    private final Logger logger = LogManager.getLogger(TVProductPage.class);

    private static final String CHARACTERISTIC_CARD_LINK = "//a[@data-tab-name='characteristics']";
    private static final String TABLE_SCREEN_REFRESH_COLUMN = "//table[@class='table-params table-no-bordered']/descendant-or-self::*[text()=' Частота обновления экрана ']";

    public TVProductPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Заголовок страницы: " + title);
        return title;
    }

    public void searchRightElement() {
        WaitFor.presenceOfElementLocatedRight(By.xpath(TABLE_SCREEN_REFRESH_COLUMN), By.xpath());
        WebElement tableRamElement = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(RelativeLocator
                        .with(By.xpath(tableRamLeft))
                        .toRightOf(By.xpath(tableRam))));
        logger.info("WebElement для проверки: " + tableRamElement.getTagName() + " содержит: " + tableRamElement.getText());
    }

}
