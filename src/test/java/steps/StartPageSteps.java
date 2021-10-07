package steps;

import io.cucumber.java.ru.Дано;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import web.drivers.BrowserName;
import web.drivers.WebDriverFactory;
import web.pages.StartPage;

@Slf4j
public class StartPageSteps {

    protected static WebDriver driver;
    private final StartPage startPage;

    public StartPageSteps(StartPage startPage) {
        this.startPage = startPage;
        log.info("Открыта страница [Стартовая страница DNS]");
    }

    @Дано("Открыта Главная страница сайта ДНС")
    public void startDriverAndOpenStartPage() {
        driver = WebDriverFactory.getDriver(BrowserName.fromString("Chrome"));
        log.info("Start Driver!");
        driver.get("https://www.dns-shop.ru/");
        log.info("Open Dns start page");
    }

}
