package web.helpers;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.support.ui.Sleeper;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import web.driver.WebDriverFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

@Slf4j
public class ScreenshotHelper {

    private static final Duration SLEEP_TIME = Duration.ofSeconds(5);

    /**
     * Функция делает скриншот страницы с заданным именем и названием директории.
     * Если директория отсутствует, то создает ее.
     * Использует задержку в 3 секунды для ожидания загрузки страницы.
     * @param nameFile имя файла
     * @param nameDirectory название директории в корне проекта по умолчанию
     */

    public static void takeScreenshot(String nameFile, String nameDirectory) {
        try {
            Sleeper.SYSTEM_SLEEPER.sleep(SLEEP_TIME);
            Path path = Paths.get(nameDirectory);
            if(!Files.exists(path)) {
                try {
                    Files.createDirectories(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Screenshot screenshot = new AShot().takeScreenshot(WebDriverFactory.getCurrentDriver());
            ImageIO.write(screenshot.getImage(), "png", new File(nameDirectory, nameFile + "_" + ".png"));
            log.info("Скриншот под именем: " + nameFile + " сохранен в директории: " + nameDirectory);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
