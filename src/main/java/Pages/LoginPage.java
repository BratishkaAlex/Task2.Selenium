package Pages;

import AppUtils.Props;
import SingletonDriver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private String loginFieldLoc = "login";

    public LoginPage() {
        driver = SingletonDriver.getDriver();
    }

    private WebElement getLoginField() {
        return driver.findElement(By.name(loginFieldLoc));
    }

    public void enterLogin() {
        getLoginField().sendKeys(Props.getProps().getProperty("login"));
        getLoginField().submit();
    }

}
