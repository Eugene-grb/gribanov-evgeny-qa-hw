import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;


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
        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Локаторы
        String cityConfirmButton =
                "//a[contains(@rel, 'nofollow noopener')]";
        String smartphonesMainCatalogButton =
                "//a[@class='ui-link menu-desktop__root-title' and contains(text(),'Смартфоны и гаджеты')]";
        String samsungSubcategoryButton =
                "//label[@class='ui-checkbox ui-checkbox_list']/descendant-or-self::*[@value='samsung']";
        String smartphoneSubcategoryButton =
                "//*[@class='ui-link menu-desktop__second-level']/descendant-or-self::*[text()='Смартфоны']";
        String applyFiltersFloatButton =
                "//div[@class='apply-filters-float-btn']";

        // Открыть страницу
        runDriver("https://www.dns-shop.ru/");

        //  Закрыть плашку подтверждение города
        pressButton(cityConfirmButton);
        logger.info("Закрыто подтверждение города");

        // Открыть подменю смартфоны и гаджеты
        WebElement element = driver.findElement(By.xpath(smartphonesMainCatalogButton));
        action.moveToElement(element).perform();

        // Нажать на смартфоны
        pressButton(smartphoneSubcategoryButton);

        // Сделать скриншот страницы
        takePageSnapshot("smartphonesPage", "temp");

        // Скролл для активации меню фильтров
        js.executeScript("window.scrollBy(0, 500)");

        // Фильтр по производителю Samsung
        pressButton(samsungSubcategoryButton);

        // Подтвердить фильтр
        pressButton(applyFiltersFloatButton);

        // Сделать скриншот страницы
        takePageSnapshot("SamsungFilterApply", "temp");

//        // Вывод названий подкатегории в логгер
//        String query = "//span[contains(@class, 'subcategory__title')]";
//        List<WebElement> elements = driver.findElements(By.xpath(query));
//        for (WebElement categoryElement : elements) {
//            logger.info("WebElement: " + categoryElement.getTagName() + " = " + categoryElement.getText());
//        }


//        // Добавление куки
//        logger.info("Добавляем наши куки");
//        driver.manage().addCookie(new Cookie("Our Cookie", "Это наши куки"));
//        Cookie cookie1  = driver.manage().getCookieNamed("Our Cookie");
//        logger.info(String.format("Domain: %s", cookie1.getDomain()));
//        logger.info(String.format("Expiry: %s",cookie1.getExpiry()));
//        logger.info(String.format("Name: %s",cookie1.getName()));
//        logger.info(String.format("Path: %s",cookie1.getPath()));
//        logger.info(String.format("Value: %s",cookie1.getValue()));
//        logger.info("--------------------------------------");
//
//        // Вывод информации по кукам DNS-Shop
//        logger.info("Куки, которое добавил DNS-Shop");
//        Set<Cookie> cookies = driver.manage().getCookies();
//        for(Cookie cookie : cookies) {
//            logger.info(String.format("Domain: %s", cookie.getDomain()));
//            logger.info(String.format("Expiry: %s", cookie.getExpiry()));
//            logger.info(String.format("Name: %s", cookie.getName()));
//            logger.info(String.format("Path: %s", cookie.getPath()));
//            logger.info(String.format("Value: %s", cookie.getValue()));
//            logger.info("--------------------------------------");
//        }

        // Задержка 10 секунд
        try {
            Thread.sleep(5000);
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

    public void pressButton(String path) {
        Actions action = new Actions(driver);
        WebElement pressButton = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));
        logger.info("WebElement: " + pressButton.getTagName());
        action.moveToElement(pressButton).click().perform();
    }



    public void runDriver(String https) {
        driver.get(https);
        String title = driver.getTitle();
        String currentUrl = driver.getCurrentUrl();

        logger.info("Открыта страница - " + https);
        logger.info("Заголовок: " + title);
        logger.info("Текущий URL: " + currentUrl);
    }

    /**
     * Функция делает скриншот страницы с заданным именем и названием директории
     * Если директория отсутствует, то создает ее
     * @param nameFile имя файла
     * @param nameDirectory название директории в корне проекта по умолчанию
     */
    public void takePageSnapshot(String nameFile, String nameDirectory) {
        try {
            //TODO: fileDate work on java 16 only
           // String fileDate = new SimpleDateFormat("dd.MM.yyyy-HH:mm").format(new Date());
            // Задержка для воспроизведения анимации, подгрузки элементов
            Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
            Path path = Paths.get(nameDirectory);
            if(!Files.exists(path)) {
                try {
                    Files.createDirectories(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Screenshot screenshot = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File(nameDirectory, nameFile + "_"+ env +".png"));
            logger.info("Скриншот под именем " + nameFile + " сохранен в директории " + nameDirectory);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
