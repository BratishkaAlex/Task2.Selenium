package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class Browser {

    public static ChromeOptions chromeMaximixe() {
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


}
