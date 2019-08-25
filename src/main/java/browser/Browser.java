package browser;

import appUtils.Props;
import appUtils.Waiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Browser {

    public static ChromeOptions chromeMaximize() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return chromeOptions;
    }

    public static void changeTab(int expectedNumber) {
        try {
            WebDriver driver = BrowserFactory.getDriver();
            driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(expectedNumber));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void enterUrl() {
        try {
            BrowserFactory.getDriver().get(Props.getProps().getProperty("url"));
        } catch (Exception e) {
            System.out.println(e);
        }
        Waiter.implicitWait(30);
    }
}
