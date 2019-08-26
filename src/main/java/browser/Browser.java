package browser;

import appUtils.Props;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class Browser {

    public static void maximize() {
        try {
            WebDriver driver = BrowserFactory.getDriver();
            driver.manage().window().maximize();
        } catch (Exception e) {
            System.out.println(e);
        }
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
    }

    public static void closeBrowser() {
        BrowserFactory.closeDriver();
    }
}
