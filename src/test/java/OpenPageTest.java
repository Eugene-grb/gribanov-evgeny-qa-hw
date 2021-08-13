import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
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


public class OpenPageTest extends PageLocators {
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        // Предустановки драйвера
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();

        logger.info("-- Открыть страницу");
        runDriver("https://www.dns-shop.ru/");

        logger.info("-- Закрыть плашку подтверждение города");
        pressButton(By.xpath(cityConfirmButton));

        logger.info("-- Открыть подменю смартфоны и гаджеты");
        selectElement(smartphonesMainCatalogButton);

        logger.info("-- Нажать на смартфоны");
        pressButton(By.xpath(smartphoneSubcategoryButton));

        logger.info("-- Сделать скриншот страницы");
        takePageSnapshot("smartphonesPage", "temp");

        // Особенности поиска динамических элементов в firefox
        logger.info("-- Скролл для активации меню фильтров");
        js.executeScript("window.scrollBy(0, 1400)");

        // Отдельная логика для правильной работы локатора
        logger.info("-- Раскрыть меню подкатегории");
        WebElement selectedElement = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.linkText("Объем оперативной памяти")));
        actions.moveToElement(selectedElement).click().perform();

        logger.info("-- Нажать на фильтр 8 Гб");
        pressButton(By.xpath(ram8GbButton));

        logger.info("-- Фильтр по производителю Samsung");
        pressButton(By.xpath(samsungSubcategoryButton));

        logger.info("-- Подтвердить все фильтры");
        pressButton(By.xpath(applyFiltersFloatButton));

        logger.info("-- Нажатие кнопки сортировки по цене");
        pressButton(By.xpath(sortCheapButton));
        pressButton(By.xpath(sortExpensiveButton));

        logger.info("-- Сделать скриншот страницы");
        takePageSnapshot("AllFiltersApply", "temp");

        logger.info("-- Открыть страницу в новом окне");
        openInNewWindow(productList);

        logger.info("-- Сделать скриншот страницы");
        takePageSnapshot("newWindowFirstResult", "temp");

        // Отдельная логика для правильной работы локатора
        logger.info("-- Перейти к характеристикам");
        WebElement characteristicFieldElement = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(characteristicField)));
        characteristicFieldElement.click();

        // Найти элемент справа от элемента для сравнения
        WebElement tableRamElement = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(RelativeLocator
                        .with(By.xpath(tableRamLeft))
                        .toRightOf(By.xpath(tableRam))));
        logger.info("WebElement для проверки: " + tableRamElement.getTagName() + " содержит: " + tableRamElement.getText());

        // Проверки
        String attributeValue = tableRamElement.getText();
        String actualTitle  = driver.getTitle();
        String expectedTitle = "Технические характеристики 6.7\" Смартфон Samsung Galaxy Z Flip3 256 ГБ бежевый | 4845670 . Интернет-магазин DNS";

        Assertions.assertEquals("8 Гб", attributeValue, "Значение поля != 8 Гб!");
        Assertions.assertEquals(expectedTitle, actualTitle, "Заголовок страницы не соответствует ожидаемому Samsung Galaxy Z Flip3");
    }

    @AfterEach
    public void setDown() {
        if(driver != null) {
            driver.quit();
            logger.info("Драйвер остановлен!");
        }
    }

    /**
     * Открывает ссылку из элемента xpath в новом окне и переключает драйвер на него
     * @param xpath элемент содержащий ссылку на страницу
     */
    public void openInNewWindow(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        new Actions(driver)
                .keyDown(Keys.LEFT_SHIFT)
                .click(element)
                .perform();
        for(String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.manage().window().maximize();
    }

    /**
     * Выделяет веб элемент и выводит информацию о нем в логгер
     * @param xpath путь до элемента
     */
    public void selectElement(String xpath) {
        Actions action = new Actions(driver);
        WebElement selectedElement = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        logger.info("Выделен WebElement: "  + selectedElement.getText());
        action.moveToElement(selectedElement).perform();
    }

    /**
     * Нажатие на элемент с проверкой на появление его в DOM
     * @param by путь до элемента
     */
    public void pressButton(By by) {
        Actions action = new Actions(driver);
        WebElement pressButton = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(by));
        logger.info("Нажат WebElement: " + pressButton.getTagName() + " под именем: " + pressButton.getText());
        action.moveToElement(pressButton).click().perform();
    }

    /**
     * Запускает драйвер и выводит в логгер информацию о странице
     * @param https ссылка на страницу
     */
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
            logger.info("Скриншот под именем: " + nameFile + " сохранен в директории: " + nameDirectory);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
