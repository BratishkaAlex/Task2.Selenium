import AppUtils.Props;
import Pages.LoginPage;
import Pages.ResultPage;
import Pages.StartPage;
import SingletonDriver.SingletonDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class MarketTest {

    @Test
    public void test() {
        WebDriver driver = SingletonDriver.getDriver();
        StartPage startPage = new StartPage();
        startPage.logIn();
        LoginPage loginPage = new LoginPage();
        loginPage.login(Props.getProps().getProperty("login"), Props.getProps().getProperty("password"));
        ResultPage resultPage = loginPage.getResultPage(0);
        //resultPage.logOut();
        // Закрываем браузер
        //driver.quit();
    }

}
