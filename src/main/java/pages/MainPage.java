package pages;

import appUtils.Waiter;
import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MainPage {

    private WebDriver driver;
    private String popularCategoryLoc = "//div[@class='n-w-tabs__horizontal-tabs']//div[@class='n-w-tab n-w-tab_type_navigation-menu']//a[@class = 'link n-w-tab__control b-zone b-spy-events']";
    private String userIconLoc = ".n-passport-suggest-popup-opener .user__icon";
    private String logOutLoc = "//a[@class='link user user__logout i-bem user_js_inited']";
    private String allCategoriesButtonLoc = ".n-w-tab__control .n-w-tab__control-hamburger";
    private String allCategoriesLoc = "//div[@class='n-w-tabs__vertical-tabs']//a";


    public MainPage() {
        try {
            driver = BrowserFactory.getDriver();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<String> getListPopCategories() {
        List<WebElement> categories = getWebElementPopCategories();
        ArrayList<String> popular = new ArrayList();
        for (WebElement elem : categories) {
            popular.add(elem.getText());
        }
        return popular;
    }

    private List<WebElement> getWebElementPopCategories() {
        List<WebElement> listCategories = driver.findElements(By.xpath(popularCategoryLoc));
        for (int i = 0; i < listCategories.size(); i++) {
            if (listCategories.get(i).getText().equals("")) {
                listCategories.remove(i);
                i--;
            }
        }
        return listCategories;
    }

    private WebElement getUserIcon() {
        Waiter.waitForClickable(By.cssSelector(userIconLoc));
        return driver.findElement(By.cssSelector(userIconLoc));
    }

    private WebElement getLogOutButton() {
        return driver.findElement(By.xpath(logOutLoc));
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
        return null;
    }

    public void clickRandomCategory(String text) {
        getRandomCategory(text).click();
    }

    private WebElement getAllCategoriesButton() {
        Waiter.waitForClickable(By.cssSelector(allCategoriesButtonLoc));
        return driver.findElement(By.cssSelector(allCategoriesButtonLoc));
    }

    public void clickOnAllCategories() {
        getAllCategoriesButton().click();
    }

    private List<WebElement> getWebElementAllCategories() {
        List<WebElement> listCategories = driver.findElements(By.xpath(allCategoriesLoc));
        return listCategories;
    }

    public ArrayList<String> getListAllCategories() {
        List<WebElement> categories = getWebElementAllCategories();
        ArrayList<String> all = new ArrayList();
        for (WebElement elem : categories) {
            all.add(elem.getText());
        }
        return all;
    }
}
