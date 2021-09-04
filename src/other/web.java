//import webdriverfactory.BrowserName;
//import webdriverfactory.ChromeBrowser;
//import webdriverfactory.FirefoxBrowser;
//import webdriverfactory.PageLoadStrategy;
//
//public class web {
//    import io.github.bonigarcia.wdm.WebDriverManager;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.PageLoadStrategy;
//import org.openqa.selenium.Platform;
//import org.openqa.selenium.UnexpectedAlertBehaviour;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.remote.CapabilityType;
//
//
//    public class WebDriverFactory {
//        private static final Logger logger = LogManager.getLogger(WebDriverFactory.class);
//
//        public static WebDriver getDriver(BrowserName browserName, PageLoadStrategy loadPageOption) {
//
//            // Стратегия загрузки страницы
//            PageLoadStrategy pageLoadStrategy;
//            switch (loadPageOption) {
//                case "none":
//                    pageLoadStrategy = PageLoadStrategy.NONE;
//                    logger.info("PageLoadStrategy = " + loadPageOption);
//                    break;
//                case "eager":
//                    pageLoadStrategy = PageLoadStrategy.EAGER;
//                    logger.info("PageLoadStrategy = " + loadPageOption);
//                    break;
//                default:
//                    pageLoadStrategy = PageLoadStrategy.NORMAL;
//                    logger.info("PageLoadStrategy = " + loadPageOption);
//            }
//
//            // Создание вебдрайвера
//            switch (browserName) {
//                case "chrome":
//                    logger.info("Драйвер для браузера Google Chrome");
//                    ChromeBrowser.getDriver();
//                case "firefox" :
//                    logger.info("Драйвер для браузера Mozilla Firefox");
//                    FirefoxBrowser.getDriver();
//                default:
//                    throw new RuntimeException("Incorrect browser name");
//            }
//        }
//    }
//}
