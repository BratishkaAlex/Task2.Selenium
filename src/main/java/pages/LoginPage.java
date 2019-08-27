package pages;

import appUtils.Waiter;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private By loginFieldLoc = By.name("login");

    public LoginPage() {
        driver = Browser.getDriver();
    }

    private WebElement getLoginField() {
        Waiter.waitForClickable(loginFieldLoc);
        return driver.findElement(loginFieldLoc);
    }

    public void enterLogin(String login) {
        getLoginField().sendKeys(login);
        getLoginField().submit();
    }

}
