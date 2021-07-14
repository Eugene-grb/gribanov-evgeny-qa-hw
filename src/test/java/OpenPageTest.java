import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class OpenPageTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(OpenPageTest.class);

    // Читаем передаваемый параметр browser (-Dbrowser)
    // mvn clean test -Dbrowser=chrome
    // mvn clean test -Dbrowser=firefox
    String env = System.getProperty("browser", "chrome");


    @BeforeEach
    public void setUp() {
        logger.info("env = " + env);
        driver = WebDriverFactory.getDriver(env.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void openPage() {
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.dns-shop.ru");
        logger.info("Открыта страница DNS-Shop - " + "https://www.dns-shop.ru");

        // Вывод заголовка страницы
        String title = driver.getTitle();
        logger.info("Title: " + title.toString());

        // Вывод текущего URL
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL: " + currentUrl.toString());
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }
}
