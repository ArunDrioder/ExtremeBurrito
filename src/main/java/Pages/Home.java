package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
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

    @FindBy(xpath = "//nav[@id='header-menu']//a[normalize-space()='About Us']")
    WebElement aboutUsHeaderButton;

    @FindBy(xpath = "//nav[@id='header-menu']//a[normalize-space()='Careers']")
    WebElement careersHeaderButton;

    @FindBy(xpath = "//nav[@id='header-menu']//a[normalize-space()='Franchise']")
    WebElement franchiseHeaderButton;


    public Home(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyURL() throws InterruptedException {
        String expectedURL = "https://www.extremeburrito.ca/";
        String actualURL = driver.getCurrentUrl();
        if (expectedURL.equals(actualURL))
            System.out.println("Test Pass!!!");


//        FluentWait<WebDriver> wait = new FluentWait<>(driver)
//
//                .withTimeout(Duration.ofSeconds(30))
//
//                .pollingEvery(Duration.ofMillis(500))
//
//                .ignoring(NoSuchElementException.class);
//
//
//        wait.until(driver -> {
//
//            foodMenu = driver.findElements(By.xpath("//h1[@class='banner-title']"));
//
//            orderNowButton = driver.findElements(By.xpath("//a[@class='custom-btn']"));
//
//
//            for (int i = 0; i < foodMenu.size(); i++) {
//
//                String menuText = foodMenu.get(i).getText().trim();
//
//                System.out.println(menuText);
//
//
//                if (menuText.equalsIgnoreCase("Quesadillas")) {
//
//                    System.out.println("Found: " + menuText + " - Clicking on Order Now button");
//
//
//                    if (i < orderNowButton.size() && orderNowButton.get(i).isDisplayed()) {
//
//                        orderNowButton.get(i).click();
//
//                        return true;
//
//                    }
//
//                }
//
//            }
//
//            return false;
//
//        });
    }

    public void goTo() {
        driver.get("https://www.extremeburrito.ca/");
    }

    public Menu goTomMenuPage() {
        menuHeaderButton.click();
        return new Menu(driver);
    }

    public ContactUs goToContactUsPage() {
        contactUsHeaderButton.click();
        return new ContactUs(driver);

    }

    public AboutUs goToAboutUsPage()
    {
        aboutUsHeaderButton.click();
        return new AboutUs(driver);

    }

    public Careers goToCareersPage()
    {
        careersHeaderButton.click();
        return new Careers(driver);

    }

    public Franchise goToFranchisePage()
    {
        franchiseHeaderButton.click();
        return new Franchise(driver);

    }


}
