import browser.Browser;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class MarketTest {

    private String titleFotMainPage = "Яндекс.Маркет — выбор и покупка товаров из проверенных интернет-магазинов";
    private String pathToCSVFile = "src/main/resources/allCategories.csv";

    @Test
    public void test() {
        Browser.enterUrl();
        UnauthorizedPage startPage = new UnauthorizedPage();
        assertTrue(startPage.getMainPageTitle().equals(titleFotMainPage), "This is note the main page");
        startPage.logIn();

        LoginPage loginPage = new LoginPage();
        loginPage.enterLogin();

        PasswordPage passwordPage = new PasswordPage();
        passwordPage.enterPassword();
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.isUserAuthorized(), "User can't authorized");
        ArrayList<String> popularCategories = mainPage.getListPopCategories();
        String randomCategory = popularCategories.get(getRandomInt(popularCategories.size()));
        mainPage.clickRandomCategory(randomCategory);
        RandomCategoryPage randomCategoryPage = new RandomCategoryPage();
        assertTrue(randomCategoryPage.getRandCatPageTitle().contains(randomCategory), "This is note the chosen random category!");
        randomCategoryPage.toMainPage();
        MainPage secondMainPage = new MainPage();
        secondMainPage.clickOnAllCategories();
        ArrayList<String> allCategories = secondMainPage.getListAllCategories();
        writeListInFile(allCategories);
        File checkFile = new File(pathToCSVFile);
        assertTrue(checkFile.exists(), "File wasn't created");
        assertTrue(isContainAllElementsInSecondList(popularCategories, allCategories), "All categories does not contain popular categories");
        secondMainPage.logOut();
        UnauthorizedPage finalPage = new UnauthorizedPage();
        assertTrue(finalPage.isLogout(), "Didn't logout!");

    }

    private int getRandomInt(int value) {
        Random rand = new Random();
        return rand.nextInt(value);
    }

    private boolean isContainAllElementsInSecondList(ArrayList list1, ArrayList list2) {
        boolean isContain = true;
        for (int i = 0; i < list1.size(); i++) {
            if (!list2.contains(list1.get(i))) {
                isContain = false;
                break;
            }
        }
        return isContain;
    }

    private void writeListInFile(ArrayList<String> list) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(pathToCSVFile);
            for (String elem : list) {
                writer.write(elem + System.getProperty("line.separator"));
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error in writing file");
        }

    }

}
