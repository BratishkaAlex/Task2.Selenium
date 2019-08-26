package browser;

import appUtils.Props;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

    private static WebDriver driver = null;

    private BrowserFactory() throws Exception {
        throw new Exception("You can't create instance of this class");
    }

    public static WebDriver getDriver() throws Exception {
        if (driver == null) {
            switch (Props.getProps().getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new Exception("Wrong browser name!");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
    }
}
