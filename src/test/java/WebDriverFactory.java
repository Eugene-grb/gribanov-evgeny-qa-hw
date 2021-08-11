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

        // Стратегия загрузки страницы
        PageLoadStrategy pageLoadStrategy;
        switch (loadPageOption) {
            case "none":
                pageLoadStrategy = PageLoadStrategy.NONE;
                logger.info("PageLoadStrategy = " + loadPageOption);
                break;
            case "eager":
                pageLoadStrategy = PageLoadStrategy.EAGER;
                logger.info("PageLoadStrategy = " + loadPageOption);
                break;
            default:
                pageLoadStrategy = PageLoadStrategy.NORMAL;
                logger.info("PageLoadStrategy = " + loadPageOption);
        }

        // Создание вебдрайвера
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                logger.info("Драйвер для браузера Google Chrome");

                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, pageLoadStrategy);
                logger.info("Стратегии загрузки страницы: " + pageLoadStrategy);
                chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
                chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
                chromeOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, false);
                chromeOptions.setAcceptInsecureCerts(false);

                // Аргументы запуска
               // chromeOptions.addArguments("--kiosk");
                chromeOptions.addArguments("--incognito");

                return new ChromeDriver(chromeOptions);
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                logger.info("Драйвер для браузера Mozilla Firefox");

                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, pageLoadStrategy);
                logger.info("Стратегии загрузки страницы: " + pageLoadStrategy);
                firefoxOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANY);
                firefoxOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
                firefoxOptions.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, false);
                firefoxOptions.setAcceptInsecureCerts(false);

                // Аргументы запуска
                firefoxOptions.addArguments("-private");
               // firefoxOptions.addArguments("--kiosk");

                return new FirefoxDriver(firefoxOptions);
            default:
                throw new RuntimeException("Incorrect browser name");
        }
    }
}