package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Franchise extends AbstractComponent
{

    WebDriver driver;

    @FindBy(xpath = "//span[@class='sm-title']")
    WebElement franchiseTitle;

    @FindBy(xpath = "//h2[@class='sec-title']")
    WebElement franchiseSubTitle;

    @FindBy(xpath = "//input[@placeholder='Your Name *']")
    WebElement franchiseName;

    @FindBy(xpath = "//input[@placeholder='Your Email *']")
    WebElement franchiseEmail;

    @FindBy(xpath = "//input[@placeholder='Your Phone *']")
    WebElement franchisePhone;

    @FindBy(xpath = "//input[@placeholder='City/Location of Interest *']")
    WebElement franchiseLocation;

    @FindBy(xpath = "//textarea[@placeholder='Tell Us About Yourself and Your Vision *']")
    WebElement franchiseVision;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement franchiseSubmitBtn;

    @FindBy(xpath = "//p[normalize-space()='Failed to send message.']")
    WebElement franchiseValidationMsg;

    public Franchise(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void verifyFranchisePageTitles()
    {
        waitFoWebElementToAppear(franchiseTitle);
        System.out.println("The title is:  "+ franchiseTitle.getText());
        waitFoWebElementToAppear(franchiseSubTitle);
        System.out.println("The SubTitle is: "+" "+franchiseSubTitle.getText());

    }

    public void fillFranchiseForm(String name, String email, String phone,String location, String vision)
    {
        franchiseName.sendKeys(name);
        franchiseEmail.sendKeys(email);
        franchisePhone.sendKeys(phone);
        franchiseLocation.sendKeys(location);
        franchiseVision.sendKeys(vision);
        scrollIntoViewIfNeeded(franchiseSubmitBtn);
        franchiseSubmitBtn.click();
        waitFoWebElementToAppear(franchiseValidationMsg);
        if (franchiseValidationMsg.isDisplayed())
            System.out.println("Msg Displayed is:" +" "+franchiseValidationMsg.getText());
        else
            System.out.println("Msg not Displayed");
    }
}
