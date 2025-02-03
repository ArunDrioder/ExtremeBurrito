package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.sql.rowset.WebRowSet;

public class Menu extends AbstractComponent {

    WebDriver driver;

    @FindBy(xpath = "//img[@alt='Image 3']")
    WebElement menuPageFirstImage;

    @FindBy(xpath = "//img[@alt='Image 2']")
    WebElement menuPageSecondImage;

    @FindBy(xpath = "//img[@alt='Image 1']")
    WebElement menuPageThirdImage;

    @FindBy(xpath = "//img[@alt='Deal 2']")
    WebElement menuPageSecondDealImage;

    @FindBy(xpath = "//img[@alt='Deal 3']")
    WebElement menuPageThirdDealImage;

    @FindBy(xpath = "//img[@alt='Deal 4']")
    WebElement menuPageFourthDealImage;

    @FindBy(xpath = "//nav[@id='header-menu']//a[normalize-space()='Contact Us']")
    WebElement contactUsHeaderMenuBtn;


    public Menu(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void checkVisibilityOfMenuImages()
    {
        scrollIntoViewIfNeeded(menuPageFirstImage);
        waitFoWebElementToAppear(menuPageFirstImage);
        if (menuPageFirstImage.isDisplayed())
            System.out.println("First Menu Image is shown");
        else
            System.out.println("First Menu Image is not shown");

        scrollIntoViewIfNeeded(menuPageSecondImage);
        waitFoWebElementToAppear(menuPageSecondImage);
        if (menuPageSecondImage.isDisplayed())
            System.out.println("Second Menu Image is shown");
        else
            System.out.println("Second Menu Image is not shown");

        scrollIntoViewIfNeeded(menuPageThirdImage);
        waitFoWebElementToAppear(menuPageThirdImage);
        if (menuPageThirdImage.isDisplayed())
            System.out.println("Third Menu Image is shown");
        else
            System.out.println("Third Menu Image is not shown");

        scrollIntoViewIfNeeded(menuPageSecondDealImage);
        waitFoWebElementToAppear(menuPageSecondDealImage);
        if (menuPageSecondDealImage.isDisplayed())
            System.out.println("Second Deal Image is present");
        else
            System.out.println("Second Deal Image is not present");

        scrollIntoViewIfNeeded(menuPageThirdDealImage);
        waitFoWebElementToAppear(menuPageThirdDealImage);
        if (menuPageThirdDealImage.isDisplayed())
            System.out.println("Third Deal Image is present");
        else
            System.out.println("Third Deal Image is not present");

        scrollIntoViewIfNeeded(menuPageFourthDealImage);
        waitFoWebElementToAppear(menuPageFourthDealImage);
        if (menuPageFourthDealImage.isDisplayed())
            System.out.println("Fourth Deal Image is present");
        else
            System.out.println("Fourth Deal Image is not present");

    }

//    public ContactUs goToContactUs()
//    {
//        contactUsHeaderMenuBtn.click();
//
//        return new ContactUs(driver);
//    }


}
