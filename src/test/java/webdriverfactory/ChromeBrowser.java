package webdriverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class ChromeBrowser {

    public static WebDriver getDriver(PageLoadStrategy pageLoadStrategy) {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
        options.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, pageLoadStrategy);
        options.addArguments("--incognito");
        options.addArguments("--start-fullscreen");

        return new ChromeDriver(options);
    }
}