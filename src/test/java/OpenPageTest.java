import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class OpenPageTest {
    protected static WebDriver driver;
    private Logger logger = LogManager.getLogger(OpenPageTest.class);

    // Читаем передаваемый параметр browser (-Dbrowser)
    // mvn clean test -Dbrowser=chrome -Doption=eager
    // mvn clean test -Dbrowser=firefox
    String env = System.getProperty("browser", "firefox");
    String loadPageOption = System.getProperty("option", "normal");


    @BeforeEach
    public void setUp() {
        logger.info("env = " + env);
        driver = WebDriverFactory.getDriver(env.toLowerCase(), loadPageOption.toLowerCase());
        logger.info("Драйвер стартовал!");
    }

    @Test
    public void openPage() {
        driver.get("https://www.dns-shop.ru");
        logger.info("Открыта страница DNS-Shop - " + "https://www.dns-shop.ru");

        // Вывод заголовка страницы
        String title = driver.getTitle();
        logger.info("Title: " + title.toString());

        // Вывод текущего URL
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL: " + currentUrl.toString());

//        // Закрыть подтверж
//        String button = "/html/body/header/div[2]/div/ul[1]/li[1]/div/div[2]/a[1]";
//        WebElement element = driver.findElement(By.xpath(button));
//        logger.info("WebElement: " + element.getTagName() + " = " + element.getText());
//        element.click();
//         // Нажать на бытовая техника
//        String button1 = "//*[@id=\"homepage-desktop-menu-wrap\"]/div/div[1]/div[1]/a";
//        WebElement element1 = driver.findElement(By.xpath(button1));
//        logger.info("WebElement: " + element1.getTagName() + " = " + element.getText());
//        element1.click();

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
    public void options(String option) {

    }
}
