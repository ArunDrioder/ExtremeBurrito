package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs extends AbstractComponent
{

    WebDriver driver;

@FindBy(xpath = "//span[@class='sm-title']")
WebElement contactUsTitle;

@FindBy(xpath = "//h2[@class='sec-title']")
WebElement subInfoTitle;

@FindBy(xpath = "//input[@placeholder='Your Name *']")
WebElement contactUsName;

@FindBy(xpath = "//input[@placeholder='Your Email *']")
WebElement contactusEmail;

@FindBy(xpath = "//input[@placeholder='Your Phone *']")
WebElement contactUsPhone;

@FindBy(xpath = "//input[@placeholder='Your Location *']")
WebElement contactUsLocation;

@FindBy(xpath = "//textarea[@placeholder='Comment *']")
WebElement contactUsComment;

@FindBy(xpath = "//button[@type='submit']")
WebElement contactUsSubmitBtn;

@FindBy(xpath = "//p[normalize-space()='Failed to send message.']")
WebElement contactUsValidationMsg;

    public ContactUs(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyUITitles()
    {
        if (contactUsTitle.isDisplayed())
            System.out.println("Contact Us page title displayed");
        else
            System.out.println("Contact Us page title not displayed");


        if (subInfoTitle.isDisplayed())
            System.out.println("Contact us page sub title is displayed");
        else
            System.out.println("Contact us page sub title is not displayed");

    }

    public void fillContactus(String name, String email, String phone, String location, String comment)
    {
        contactUsName.sendKeys(name);
        contactusEmail.sendKeys(email);
        contactUsPhone.sendKeys(phone);
        contactUsLocation.sendKeys(location);
        scrollIntoViewIfNeeded(contactUsComment);
        contactUsComment.sendKeys(comment);
        scrollIntoViewIfNeeded(contactUsSubmitBtn);
        contactUsSubmitBtn.click();
        waitFoWebElementToAppear(contactUsValidationMsg);
        scrollIntoViewIfNeeded(contactUsValidationMsg);

        if (contactUsValidationMsg.isDisplayed())
            System.out.println("Msg displayed is:"+" "+contactUsValidationMsg.getText());
        else
            System.out.println("Msg not displayed");
    }
}
