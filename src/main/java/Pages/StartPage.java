package Pages;

import AppUtils.Props;
import SingletonDriver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class StartPage {
    private WebDriver driver;
    private String loginXpath = "(//a[contains(.,'Войти')])[2]";

    public StartPage() {
        driver = SingletonDriver.getDriver();
        driver.get(Props.getProps().getProperty("url"));
    }

    private WebElement getLoginButton() {
        return driver.findElement(By.xpath(loginXpath));
    }

    public void logIn() {
        getLoginButton().click();
        changeTab(1);
    }

    private void changeTab(int expectedNumber) {
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(expectedNumber));
    }
}
