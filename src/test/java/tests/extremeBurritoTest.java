package tests;

import Pages.ContactUs;
import Pages.Menu;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testComponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class extremeBurritoTest extends BaseTest {
    @Test(priority = 1)
    public void homePageTest() throws InterruptedException {
        home.verifyURL();
    }

    @Test

    public void menuPageTest() {
        home.goTomMenuPage();
        Menu menu = new Menu(driver);
        menu.checkVisibilityOfMenuImages();

    }

    @Test(dataProvider = "getData")

    public void contactUsPageTest(HashMap<String, String> input) {

        home.goToContactUsPage();
        ContactUs contactUs = new ContactUs(driver);
        contactUs.verifyUITitles();
        contactUs.fillContactus(input.get("name"),input.get("email"),input.get("phone"),input.get("location"),input.get("comment"));

    }


    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//data//DataFile.json");
        return new Object[][]{{data.get(0)}};
    }


}
