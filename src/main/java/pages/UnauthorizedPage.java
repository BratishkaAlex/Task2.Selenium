package pages;

import browser.Browser;
import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UnauthorizedPage {
    private WebDriver driver;
    private String loginLoc = ".n-passport-suggest-popup-opener .button2";

    public UnauthorizedPage() {
        try {
            driver = BrowserFactory.getDriver();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private WebElement getLoginButton() {
        return driver.findElement(By.cssSelector(loginLoc));
    }

    public void logIn() {
        Actions btnClick = new Actions(driver);
        btnClick.click(getLoginButton()).perform();
        Browser.changeTab(1);
    }

    public String getMainPageTitle() {
        return driver.getTitle();
    }

    public boolean isLogout() {
        return getLoginButton().isDisplayed();
    }
}
