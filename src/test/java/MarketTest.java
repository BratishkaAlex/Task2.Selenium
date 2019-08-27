import appUtils.Props;
import appUtils.Waiter;
import appUtils.Writer;
import browser.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class MarketTest {

    private String pathToCSVFile = "src/main/resources/allCategories.csv";

    @BeforeTest
    public void setUp() {
        Browser.setUp(Props.getProperty("browser"));
        Browser.enterUrl(Props.getProperty("url"));
        Browser.maximize();
        Waiter.implicitWait(30);
    }

    @AfterTest
    public void closeBrowser() {
        Browser.closeBrowser();
    }

    @Test
    public void test() {
        UnauthorizedPage startPage = new UnauthorizedPage();
        assertTrue(startPage.isMainPage(), "This is not the main page");
        startPage.logIn();

        LoginPage loginPage = new LoginPage();
        loginPage.enterLogin(Props.getProperty("login"));

        PasswordPage passwordPage = new PasswordPage();
        passwordPage.enterPassword(Props.getProperty("password"));

        MainPage mainPage = new MainPage();
        assertTrue(mainPage.isUserAuthorized(), "User couldn't authorized");
        ArrayList<String> popularCategories = mainPage.getListPopCategories();
        String randomCategory = popularCategories.get(getRandomInt(popularCategories.size()));
        mainPage.clickRandomCategory(randomCategory);

        RandomCategoryPage randomCategoryPage = new RandomCategoryPage();
        assertTrue(randomCategoryPage.getRandCatPageTitle().toLowerCase().contains(randomCategory.toLowerCase()), "This is not the chosen random category page!");
        randomCategoryPage.toMainPage();

        MainPage secondMainPage = new MainPage();
        secondMainPage.clickOnAllCategories();
        ArrayList<String> allCategories = secondMainPage.getListAllCategories();
        Writer.writeListInFile(allCategories, pathToCSVFile);
        File checkFile = new File(pathToCSVFile);
        assertTrue(checkFile.exists(), "CSV file wasn't created");
        assertTrue(allCategories.containsAll(popularCategories), "All categories does not contain popular categories");
        secondMainPage.logOut();

        UnauthorizedPage finalPage = new UnauthorizedPage();
        assertTrue(finalPage.isLogout(), "Didn't logout!");
    }

    private int getRandomInt(int value) {
        Random rand = new Random();
        return rand.nextInt(value);
    }

}
