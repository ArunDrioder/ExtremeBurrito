package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home extends AbstractComponent {

    WebDriver driver;

    @FindBy(xpath = "//h1[@class='banner-title']")
    private List<WebElement> foodMenu;

    @FindBy(xpath = "//a[@class='custom-btn']")
    private List<WebElement> orderNowButton;

    @FindBy(xpath = "//nav[@id='header-menu']//a[normalize-space()='Menu']")
    WebElement menuHeaderButton;

    @FindBy(xpath = "//nav[@id='header-menu']//a[normalize-space()='Contact Us']")
    WebElement contactUsHeaderButton;





    public Home(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyURL() throws InterruptedException
    {
        String expectedURL = "https://www.extremeburrito.ca/";
        String actualURL = driver.getCurrentUrl();
        if (expectedURL.equals(actualURL))
            System.out.println("Test Pass!!!");
    }

    public void goTo()
    {
        driver.get("https://www.extremeburrito.ca/");
    }

    public Menu goTomMenuPage()
    {
        menuHeaderButton.click();
        return new Menu(driver);
    }

    public ContactUs goToContactUsPage()
    {
        contactUsHeaderButton.click();
        return new ContactUs(driver);

    }






}
