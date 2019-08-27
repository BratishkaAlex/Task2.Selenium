package pages;

import appUtils.Waiter;
import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MainPage {

    private WebDriver driver;
    private By popularCategoryLoc = By.xpath("//div[@class='n-w-tabs__horizontal-tabs']//div[@class='n-w-tab n-w-tab_type_navigation-menu']");
    private By userIconLoc = By.cssSelector(".n-passport-suggest-popup-opener .user__icon");
    private By logOutLoc = By.xpath("//a[contains(@class,'user__logout')]");
    private By allCategoriesButtonLoc = By.cssSelector(".n-w-tab__control .n-w-tab__control-hamburger");
    private By allCategoriesLoc = By.xpath("//div[@class='n-w-tabs__vertical-tabs']//a");


    public MainPage() {
        driver = Browser.getDriver();
    }

    public ArrayList<String> getListPopCategories() {
        List<WebElement> categories = getWebElementPopCategories();
        ArrayList<String> popular = new ArrayList<>();
        for (WebElement elem : categories) {
            popular.add(elem.getText());
        }
        return popular;
    }

    private List<WebElement> getWebElementPopCategories() {
        Waiter.waitForClickable(popularCategoryLoc);
        List<WebElement> listCategories = driver.findElements(popularCategoryLoc);
        for (int i = 0; i < listCategories.size(); i++) {
            if (listCategories.get(i).getText().equals("")) {
                listCategories.remove(i);
                i--;
            }
        }
        return listCategories;
    }

    private WebElement getUserIcon() {
        Waiter.waitForClickable(userIconLoc);
        return driver.findElement(userIconLoc);
    }

    private WebElement getLogOutButton() {
        return driver.findElement(logOutLoc);
    }

    public void logOut() {
        getUserIcon().click();
        getLogOutButton().click();
    }

    public boolean isUserAuthorized() {
        return getUserIcon().isDisplayed();
    }


    private WebElement getRandomCategory(String text) {
        List<WebElement> listCategories = getWebElementPopCategories();
        for (WebElement elem : listCategories) {
            if (elem.getText().equals(text)) {
                return elem;
            }
        }
        throw new NoSuchElementException("There isn't random chosen category in popular categories");
    }

    public void clickRandomCategory(String text) {
        getRandomCategory(text).click();
    }

    private WebElement getAllCategoriesButton() {
        Waiter.waitForClickable(allCategoriesButtonLoc);
        return driver.findElement(allCategoriesButtonLoc);
    }

    public void clickOnAllCategories() {
        getAllCategoriesButton().click();
    }

    private List<WebElement> getWebElementAllCategories() {
        return driver.findElements(allCategoriesLoc);
    }

    public ArrayList<String> getListAllCategories() {
        List<WebElement> categories = getWebElementAllCategories();
        ArrayList<String> all = new ArrayList<>();
        for (WebElement elem : categories) {
            all.add(elem.getText());
        }
        return all;
    }
}
