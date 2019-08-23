import org.testng.annotations.Test;
import pages.LoginPage;
import pages.PasswordPage;
import pages.ResultPage;
import pages.StartPage;

import java.util.ArrayList;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class MarketTest {

    @Test
    public void test() {
        StartPage startPage = new StartPage();
        assertTrue(startPage.getMainPageTitle().equals("Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов"), "This is note the main page");
        startPage.logIn();

        LoginPage loginPage = new LoginPage();
        loginPage.enterLogin();

        PasswordPage passwordPage = new PasswordPage();
        passwordPage.enterPassword();

        ResultPage resultPage = new ResultPage();
        assertTrue(resultPage.isUserAuthorized(), "User can't authorized");
        ArrayList<String> popularCategories = resultPage.getListCategories();
        for (String elem : popularCategories) {
            System.out.println(elem);
        }
        //resultPage.chooseRandomCat(popularCategories.get(getRandomInt(popularCategories)));
        //resultPage.logOut();
    }

    private int getRandomInt(ArrayList list) {
        Random rand = new Random(list.size());
        return rand.nextInt();
    }

}
