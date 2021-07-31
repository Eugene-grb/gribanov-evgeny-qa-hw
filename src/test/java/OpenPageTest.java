import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class OpenPageTest {
    protected static WebDriver driver;
    private final Logger logger = LogManager.getLogger(OpenPageTest.class);

    // mvn clean test -Dbrowser=chrome -Doption=normal
    String env = System.getProperty("browser", "chrome");
    String loadPageOption = System.getProperty("option", "normal");


    @BeforeEach
    public void setUp() {
        logger.info("env = " + env);
        driver = WebDriverFactory.getDriver(env.toLowerCase(), loadPageOption.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void openPage() {
        // Ожидание загрузки страницы
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.get("https://www.dns-shop.ru");
        logger.info("Открыта страница DNS-Shop - https://www.dns-shop.ru");

        // Вывод заголовка страницы
        String title = driver.getTitle();
        logger.info("Заголовок: " + title);

        // Вывод текущего URL
        String currentUrl = driver.getCurrentUrl();
        logger.info("Текущий URL: " + currentUrl);

        //  Закрыть плашку подтверждение города
        String buttonok = "//a[contains(text(),'Да')]";
        WebElement elementok = driver.findElement(By.xpath(buttonok));
        logger.info("WebElement: " + elementok.getTagName() + " = " + elementok.getText());
        elementok.click();
        logger.info("Закрыто подтверждение города");


        // Нажать на бытовая техника
       String catalogButtonOK = "//a[contains(text(),'Бытовая техника')]";
        WebElement catalogButton = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(catalogButtonOK)));
        logger.info("WebElement: " + catalogButton.getTagName() + " = " + catalogButton.getText());
        logger.info("Переход на страницу 'Бытовая техника'");
       catalogButton.click();

        // Вывод названий подкатегории в логгер
        String query = "//span[contains(@class, 'subcategory__title')]";
        List<WebElement> elements = driver.findElements(By.xpath(query));
        for (WebElement categoryElement : elements) {
            logger.info("WebElement: " + categoryElement.getTagName() + " = " + categoryElement.getText());
        }


        // Добавление куки
        logger.info("Добавляем наши куки");
        driver.manage().addCookie(new Cookie("Our Cookie", "Это наши куки"));
        Cookie cookie1  = driver.manage().getCookieNamed("Our Cookie");
        logger.info(String.format("Domain: %s", cookie1.getDomain()));
        logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
        logger.info(String.format("Name: %s",cookie1.getName()));
        logger.info(String.format("Path: %s",cookie1.getPath()));
        logger.info(String.format("Value: %s",cookie1.getValue()));
        logger.info("--------------------------------------");

        // Вывод информации по кукам DNS-Shop
        logger.info("Куки, которое добавил DNS-Shop");
        Set<Cookie> cookies = driver.manage().getCookies();
        for(Cookie cookie : cookies) {
            logger.info(String.format("Domain: %s", cookie.getDomain()));
            logger.info(String.format("Expiry: %s", cookie.getExpiry()));
            logger.info(String.format("Name: %s", cookie.getName()));
            logger.info(String.format("Path: %s", cookie.getPath()));
            logger.info(String.format("Value: %s", cookie.getValue()));
            logger.info("--------------------------------------");
        }

        // Задержка 10 секунд
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
