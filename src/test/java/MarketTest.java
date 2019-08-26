import appUtils.Waiter;
import browser.Browser;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class MarketTest {

    private String titleFotMainPage = "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов";
    private String pathToCSVFile = "src/main/resources/allCategories.csv";

    @BeforeTest
    public void setUp() {
        Browser.enterUrl();
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
        assertTrue(startPage.getMainPageTitle().equals(titleFotMainPage), "This is note the main page");
        startPage.logIn();

        LoginPage loginPage = new LoginPage();
        loginPage.enterLogin();

        PasswordPage passwordPage = new PasswordPage();
        passwordPage.enterPassword();

        MainPage mainPage = new MainPage();
        assertTrue(mainPage.isUserAuthorized(), "User couldn't authorized");
        ArrayList<String> popularCategories = mainPage.getListPopCategories();
        String randomCategory = popularCategories.get(getRandomInt(popularCategories.size()));
        mainPage.clickRandomCategory(randomCategory);

        RandomCategoryPage randomCategoryPage = new RandomCategoryPage();
        assertTrue(randomCategoryPage.getRandCatPageTitle().contains(randomCategory), "This is not the chosen random category page!");
        randomCategoryPage.toMainPage();

        MainPage secondMainPage = new MainPage();
        secondMainPage.clickOnAllCategories();
        ArrayList<String> allCategories = secondMainPage.getListAllCategories();
        writeListInFile(allCategories);
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

    private void writeListInFile(ArrayList<String> list) {
        PrintWriter writer;
        try {
            switch (System.getProperty("os.name")) {
                case "Linux":
                    writer = new PrintWriter(pathToCSVFile, "UTF-8");
                    break;
                case "Windows 10":
                    writer = new PrintWriter(pathToCSVFile, "windows-1251");
                    break;
                default:
                    throw new Exception("Unknown OS");
            }
            for (String elem : list) {
                writer.write(elem + System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error in writing file");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
