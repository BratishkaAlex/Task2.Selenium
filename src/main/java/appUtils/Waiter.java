package appUtils;

import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public static void waitForClickable(By element) {
        try {
            WebDriverWait wait = new WebDriverWait(BrowserFactory.getDriver(), 5);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
