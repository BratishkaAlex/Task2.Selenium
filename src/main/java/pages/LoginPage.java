package pages;

import appUtils.Props;
import appUtils.Waiter;
import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private String loginFieldLoc = "login";

    public LoginPage() {
        try {
            driver = BrowserFactory.getDriver();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private WebElement getLoginField() {
        Waiter.waitForClickable(By.name(loginFieldLoc));
        return driver.findElement(By.name(loginFieldLoc));
    }

    public void enterLogin() {
        getLoginField().sendKeys(Props.getProps().getProperty("login"));
        getLoginField().submit();
    }

}
