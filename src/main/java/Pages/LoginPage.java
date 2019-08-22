package Pages;

import SingletonDriver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver driver;
    ArrayList<String> tabs;

    public LoginPage() {
        driver = SingletonDriver.getDriver();
    }

    private void enterField(String fieldsName, String value) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement inputValue = driver.findElement(By.name(fieldsName));
        inputValue.sendKeys(value);
        inputValue.submit();
    }

    public void login(String login, String password) {
        enterField("login", login);
        enterField("passwd", password);
    }

    public ResultPage getResultPage(int expectedNumber) {
        tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(expectedNumber));
        return new ResultPage(driver);
    }
}
