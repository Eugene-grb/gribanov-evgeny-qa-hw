package pages;

import elements.Button;
import elements.Link;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

  private static final String URL = "https://www.dns-shop.ru";
  private static final String CITY_CONFIRM_BUTTON = "//a[contains(@rel, 'nofollow noopener')]";
  private static final String CATALOG_TV_BUTTON = "//a[@class='ui-link menu-desktop__root-title' and contains(text(),'ТВ и мультимедиа')]";
  private static final String SUBCATALOG_TV_BUTTON = "//*[@class='ui-link menu-desktop__second-level']/descendant-or-self::*[text()='Телевизоры']";

  private final Logger logger = LogManager.getLogger(MainPage.class);

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public String getUrl() {
    return URL;
  }

  public void openPage() {
    driver.get(URL);
    logger.info("Открыта страница " + driver.getTitle());
  }

  public void closeCityConfirmAlert() {
    Button cityConfirmButton = new Button(driver, By.xpath(CITY_CONFIRM_BUTTON));
    cityConfirmButton.click();
    logger.info("Закрыто окно подтверждение города");
  }

  public void linkTVsMainCatalogButtonMove() {
    Link catalogButton = new Link(driver, By.xpath(CATALOG_TV_BUTTON));
    catalogButton.focusOnLink();
    logger.info("Нажата ссылка 'ТВ и мультимедиа'");
  }

  public void linkTVsSubcatalogClick() {
    Link smartphonesButton = new Link(driver, By.xpath(SUBCATALOG_TV_BUTTON));
    smartphonesButton.click();
    logger.info("Нажата ссылка 'Телевизоры'");
  }
}
