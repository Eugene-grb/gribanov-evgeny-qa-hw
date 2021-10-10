package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import web.driver.WebDriverFactory;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

@Log4j2
public class ScreenShotHooks {

    @BeforeStep
    public void takeScreenshotBeforeStep(Scenario scenario) {
        try {
            Screenshot screenshot = new AShot().takeScreenshot(
                    WebDriverFactory.getCurrentDriver());
            String name = scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png";
            ImageIO.write(screenshot.getImage(), "png",
                    new File("temp/" + name));
            log.info("Скриншот сохранен в файле [temp/" + name + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        try {
            Screenshot screenshot = new AShot().takeScreenshot(
                    WebDriverFactory.getCurrentDriver());
            String name = scenario.getName() + "-" + Timestamp.from(Instant.now()).getTime() + ".png";
            ImageIO.write(screenshot.getImage(), "png",
                    new File("temp/" + name));
            log.info("Скриншот сохранен в файле [temp/" + name + "]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
