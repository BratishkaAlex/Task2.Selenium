package pages;

import appUtils.Waiter;
import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RandomCategoryPage {

    private WebDriver driver;
    private String linkToMainPage = "//a[@class='logo logo_type_link logo_part_market']";

    public RandomCategoryPage() {
        try {
            driver = BrowserFactory.getDriver();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private WebElement getLinkToMainPage() {
        Waiter.waitForClickable(By.xpath(linkToMainPage));
        return driver.findElement(By.xpath(linkToMainPage));
    }

    public void toMainPage() {
        getLinkToMainPage().click();
    }

    public String getRandCatPageTitle() {
        return driver.getTitle();
    }
}
