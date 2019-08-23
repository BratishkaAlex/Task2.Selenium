import pages.LoginPage;
import pages.PasswordPage;
import pages.ResultPage;
import pages.StartPage;
import org.testng.annotations.Test;

public class MarketTest {

    @Test
    public void test() throws InterruptedException {
        StartPage startPage = new StartPage();
        startPage.logIn();
        LoginPage loginPage = new LoginPage();
        loginPage.enterLogin();
        PasswordPage passwordPage = new PasswordPage();
        passwordPage.enterPassword();
        ResultPage resultPage = new ResultPage();
        resultPage.getListCategories();
       // resultPage.logOut();
        //driver.quit();
    }

}
