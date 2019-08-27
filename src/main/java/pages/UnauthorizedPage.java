package pages;

import appUtils.Waiter;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UnauthorizedPage {
    private WebDriver driver;
    private By loginLoc = By.cssSelector(".n-passport-suggest-popup-opener .button2");
    private By bannerLoc = By.xpath("//div[contains(@data-zone-name, 'Banner')]");

    public UnauthorizedPage() {
        driver = Browser.getDriver();
    }

    private WebElement getLoginButton() {
        Waiter.waitForClickable(loginLoc);
        return driver.findElement(loginLoc);
    }

    public void logIn() {
        Actions btnClick = new Actions(driver);
        btnClick.click(getLoginButton()).perform();
        Browser.changeTab(1);
    }

    public boolean isLogout() {
        return getLoginButton().isDisplayed();
    }

    public boolean isMainPage() {
        return getBanner().isDisplayed();
    }

    public WebElement getBanner() {
        return driver.findElement(bannerLoc);
    }

}
