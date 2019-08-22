package Pages;

import SingletonDriver.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultPage {

    private WebDriver driver;
    private String popularCategory = "//span[@class = 'n-w-tab__control-caption']";
    private String userIconLoc = "(//span[contains(@class,'yes')])[5]";
    private String logOutLoc = "//a[@class='link user user__logout i-bem user_js_inited']";

    public ResultPage() {
        driver = SingletonDriver.getDriver();
    }

    public ArrayList<String> getListCategories(){

        return new ArrayList<String> ();
    }

    private List<WebElement> getWebElementCategory(){
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
