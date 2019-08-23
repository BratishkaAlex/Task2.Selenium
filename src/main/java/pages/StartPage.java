package pages;

import appUtils.Props;
import appUtils.Waiter;
import browser.Browser;
import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StartPage {
    private WebDriver driver;
    private String loginXpath = "(//a[contains(.,'Войти')])[2]";

    public StartPage() {
        try {
            driver = BrowserFactory.getDriver();
        } catch (Exception e) {
            System.out.println(e);
        }
        driver.get(Props.getProps().getProperty("url"));
        Waiter.implicitWait(30);
    }

    private WebElement getLoginButton() {
        return driver.findElement(By.xpath(loginXpath));
    }

    public void logIn() {
        getLoginButton().click();
        Browser.changeTab(1);
    }

    public String getMainPageTitle() {
        return driver.getTitle();
    }
}
