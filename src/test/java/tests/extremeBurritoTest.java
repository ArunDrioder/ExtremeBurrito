package tests;
import Pages.AboutUs;
import Pages.Careers;
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

    @Test (priority = 2)

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
        contactUs.fillContactus(input.get("name"), input.get("email"), input.get("phone"), input.get("location"), input.get("comment"));

    }

    @Test (priority = 3)
    public void aboutUsPageTest() {
        home.goToAboutUsPage();
        AboutUs aboutUs = new AboutUs(driver);
        aboutUs.verifyAboutUs();
        aboutUs.verifyVision();
        aboutUs.verifyCoresValues();
    }
//
    @Test(dataProvider = "getData")
    public void careerPageTest(HashMap<String, String> input)
    {
        home.goToCareersPage();
        Careers careers = new Careers(driver);
        careers.verifyCareerPageUIElements();
        careers.fillCareers(input.get("name"),input.get("email"),input.get("phone"),input.get("location"),input.get("coverLetter"), input.get("cv"));
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//data//DataFile.json");
        return new Object[][]{{data.get(0)}};
    }


}
