import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;


public class WebDriverFactory {
    private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);

    public static WebDriver getDriver(String browserName, String loadPageOption) {
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                logger.info("Драйвер для браузера Google Chrome");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
                chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
                chromeOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, false);
                chromeOptions.setAcceptInsecureCerts(false);

                switch (loadPageOption) {
                    case "none":
                        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                        logger.info("PageLoadStrategy = " + loadPageOption);
                        break;
                    case "eager":
                        chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                        logger.info("PageLoadStrategy = " + loadPageOption);
                        break;
                    default:
                        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                        logger.info("PageLoadStrategy = " + loadPageOption);
                }

                chromeOptions.addArguments("--kiosk");
                chromeOptions.addArguments("--incognito");

                return new ChromeDriver(chromeOptions);
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                logger.info("Драйвер для браузера Mozilla Firefox");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
                firefoxOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
                firefoxOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, false);
                firefoxOptions.setAcceptInsecureCerts(false);

                switch (loadPageOption) {
                    case "none":
                        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                        logger.info("PageLoadStrategy = " + loadPageOption);
                        break;
                    case "eager":
                        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
                        logger.info("PageLoadStrategy = " + loadPageOption);
                        break;
                    default:
                        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                        logger.info("PageLoadStrategy = " + loadPageOption);
                }

                firefoxOptions.addArguments("-private");
                firefoxOptions.addArguments("--kiosk");

                return new FirefoxDriver(firefoxOptions);
            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }
}