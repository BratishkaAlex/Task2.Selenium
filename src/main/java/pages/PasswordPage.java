package pages;

import appUtils.Waiter;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordPage {
    private WebDriver driver;
    private By passwordFieldLoc = By.name("passwd");

    public PasswordPage() {
        driver = Browser.getDriver();
    }

    private WebElement getPasswordField() {
        Waiter.waitForClickable(passwordFieldLoc);
        return driver.findElement(passwordFieldLoc);
    }

    public void enterPassword(String password) {
        getPasswordField().sendKeys(password);
        getPasswordField().submit();
        Browser.changeTab(0);
    }


}
