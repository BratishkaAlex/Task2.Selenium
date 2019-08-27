package pages;

import appUtils.Waiter;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RandomCategoryPage {

    private WebDriver driver;
    private By linkToMainPage = By.xpath("//a[contains(@class, 'logo_part_market')]");

    public RandomCategoryPage() {
        driver = Browser.getDriver();
    }

    private WebElement getLinkToMainPage() {
        Waiter.waitForClickable(linkToMainPage);
        return driver.findElement(linkToMainPage);
    }

    public void toMainPage() {
        getLinkToMainPage().click();
    }

    public String getRandCatPageTitle() {
        return driver.getTitle();
    }
}
