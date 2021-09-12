package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshots {

    private static final Logger logger = LogManager.getLogger(Screenshots.class);
    protected static WebDriver driver;
    protected static Screenshot screenshot;

    /**
     // * Функция делает скриншот страницы с заданным именем и названием директории
     // * Если директория отсутствует, то создает ее
     // * @param nameFile имя файла
     // * @param directory название директории в корне проекта по умолчанию
     */

    public static void takeScreenshot(String nameFile, String directory) {
        try {
            if (JSExecutor.pageIsLoaded(driver)) {
                Path path = Paths.get(directory);
                if (!Files.exists(path)) {
                    try {
                        Files.createDirectories(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
            Screenshot screenshot = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File(directory, nameFile + ".png"));
            logger.info("Скриншот под именем: " + nameFile + " сохранен в директории: " + directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ssssss(String nameFile, String directory) {
        if (JSExecutor.pageIsLoaded(driver)) {
            Path path = Paths.get(directory);
            if (!Files.exists(path)) {
                try {
                    Files.createDirectories(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            screenshot = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File(directory, nameFile + ".png"));
            logger.info("Скриншот под именем: " + nameFile + " сохранен в директории: " + directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void MakeAScreenshot(String format, String name, WebDriver driver) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            screenshot = new AShot().takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), format, new File("temp\\" + name + "." + format));
            logger.info("Скриншот сохранен в [temp/" + name + "." + format + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
