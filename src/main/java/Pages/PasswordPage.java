package Pages;

import AppUtils.Props;
import SingletonDriver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class PasswordPage {
    private WebDriver driver;
    private String passwordFieldLoc = "passwd";

    public PasswordPage() {
        driver = SingletonDriver.getDriver();
    }

    private WebElement getPasswordField() {
        return driver.findElement(By.name(passwordFieldLoc));
    }

    public void enterPassword() throws InterruptedException {
        getPasswordField().sendKeys(Props.getProps().getProperty("password"));
        getPasswordField().submit();
        changeTab(0);
    }

    private void changeTab(int expectedNumber) {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(expectedNumber));
    }
}
