package pages;

import appUtils.Props;
import browser.Browser;
import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PasswordPage {
    private WebDriver driver;
    private String passwordFieldLoc = "passwd";

    public PasswordPage() {
        try {
            driver = BrowserFactory.getDriver();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private WebElement getPasswordField() {
        return driver.findElement(By.name(passwordFieldLoc));
    }

    public void enterPassword() throws InterruptedException {
        getPasswordField().sendKeys(Props.getProps().getProperty("password"));
        getPasswordField().submit();
        Browser.changeTab(0);
    }


}
