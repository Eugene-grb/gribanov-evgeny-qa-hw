package web.pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import web.elements.Button;
import web.elements.Link;

@Log4j2
public class MainPage extends BasePage {

  private static final String CITY_CONFIRM_BUTTON = "//a[contains(@rel, 'nofollow noopener')]";
  private static final String CATALOG_TV_BUTTON = "//a[@class='ui-link menu-desktop__root-title' and contains(text(),'ТВ и мультимедиа')]";
  private static final String SUBCATALOG_TV_BUTTON = "//*[@class='ui-link menu-desktop__second-level']/descendant-or-self::*[text()='Телевизоры']";

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public void closeCityConfirmAlert() {
    Button cityConfirmButton = new Button(By.xpath(CITY_CONFIRM_BUTTON));
    cityConfirmButton.click();
    log.info("Закрыто окно подтверждение города");
  }

  public void linkTVsMainCatalogButtonMove() {
    Link catalogButton = new Link(By.xpath(CATALOG_TV_BUTTON));
    catalogButton.focusOnLink();
    log.info("Нажата ссылка 'ТВ и мультимедиа'");
  }

  public void linkTVsSubcatalogClick() {
    Link smartphonesButton = new Link(By.xpath(SUBCATALOG_TV_BUTTON));
    smartphonesButton.click();
    log.info("Нажата ссылка 'Телевизоры'");
  }
}
