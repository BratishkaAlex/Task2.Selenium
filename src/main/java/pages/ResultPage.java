package pages;

import browser.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultPage {

    private WebDriver driver;
    private String popularCategory = "//a[@class = 'link n-w-tab__control b-zone b-spy-events']";
    private String userIconLoc = "(//span[contains(@class,'yes')])[5]";
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
        ArrayList<String> popular = new ArrayList<>();
        for (WebElement elem : categories) {
            if (!elem.getText().equals("")) {
                popular.add(elem.getText());
            }
        }
        System.out.println(popular.size());
        return popular;
    }

    private List<WebElement> getWebElementCategories() {
        return driver.findElements(By.xpath("//span[@class = 'n-w-tab__control-caption']"));
    }
/*
    private WebElement getUserIcon() {
        return driver.findElement(By.xpath(userIconLoc));
    }

    private WebElement getLogOutButton() {
        return driver.findElement(By.xpath(logOutLoc));
    }

    public void logOut() {
        getUserIcon().click();
        getLogOutButton().click();
    }

 */
}
