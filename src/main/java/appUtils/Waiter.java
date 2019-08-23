package appUtils;

import browser.BrowserFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Waiter {
    public static void implicitWait(long time) {
        try {
            WebDriver driver = BrowserFactory.getDriver();
            driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
