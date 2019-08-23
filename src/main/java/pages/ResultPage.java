package pages;

import appUtils.Waiter;
import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultPage {

    private WebDriver driver;
    private String popularCategory = "//div[@class='n-w-tabs__horizontal-tabs']//a[@class = 'link n-w-tab__control b-zone b-spy-events']";
    private String userIconLoc = ".n-passport-suggest-popup-opener .user__icon";
    private String logOutLoc = "//a[@class='link user user__logout i-bem user_js_inited']";

    public ResultPage() {
        try {
            driver = BrowserFactory.getDriver();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<String> getListCategories() {
        List<WebElement> categories = getWebElementCategories();
        ArrayList<String> popular = new ArrayList();
        for (WebElement elem : categories) {
            popular.add(elem.getText());
        }
        return popular;
    }

    private List<WebElement> getWebElementCategories() {
        List<WebElement> listCategories = driver.findElements(By.xpath(popularCategory));
        for (int i = 0; i < listCategories.size(); i++) {
            if (listCategories.get(i).getText().equals("Скидки и акции") || listCategories.get(i).getText().equals("")) {
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


    public void chooseRandomCat(String text) {

    }

    private WebElement getRandomCategory(String text) {
        List<WebElement> listCategories = getWebElementCategories();
        return null;
    }
}
