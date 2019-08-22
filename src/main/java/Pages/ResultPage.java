package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ResultPage {

    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickButtonXPath(String xpath) {
        WebElement outButton = driver.findElement(By.xpath(xpath));
        outButton.click();
    }

    public void logOut() {
        clickButtonXPath("(//span[contains(@class,'user__icon user__icon_loaded_yes')])[2]");
        clickButtonXPath("//a[contains(.,'Выйти')]");
    }
}
