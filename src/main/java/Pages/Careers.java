package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Careers extends AbstractComponent
{
    WebDriver driver;

    @FindBy(xpath = "//span[text()='Careers']")
    WebElement careersTitle;

    @FindBy(xpath = "//h2[normalize-space()='Join Our Team']")
    WebElement careerSubTitle;

    @FindBy(xpath = "//input[@placeholder='Your Name *']")
    WebElement careerInputName;

    @FindBy(xpath = "//input[@placeholder='Your Email *']")
    WebElement careerInputEmail;

    @FindBy(xpath = "//input[@placeholder='Your Phone *']")
    WebElement careerInputPhone;

    @FindBy(xpath = "//input[@placeholder='City/Location of Interest *']")
    WebElement careerInputCity;

    @FindBy(xpath = "//textarea[@placeholder='Cover Letter *']")
    WebElement careerInputCoverLetter;

    @FindBy(xpath = "//input[@name='file']")
    WebElement careerInputCV;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement careerFormSubmitBtn;

    @FindBy(xpath = "//p[normalize-space()='Failed to send message.']")
    WebElement careerFormValidationMsg;


    public Careers(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void verifyCareerPageUIElements()
    {
        System.out.println("The title is:"+" "+careersTitle.getText());
        System.out.println("The Sub-title is:"+" "+careerSubTitle.getText());
    }

    public void fillCareers(String name, String email, String phone, String city, String coverLetter, String cv)
    {
        careerInputName.sendKeys(name);
        careerInputEmail.sendKeys(email);
        careerInputPhone.sendKeys(phone);
        careerInputCity.sendKeys(city);
        careerInputCoverLetter.sendKeys(coverLetter);
        scrollIntoViewIfNeeded(careerInputCV);
        careerInputCV.sendKeys(cv);
        scrollIntoViewIfNeeded(careerFormSubmitBtn);
        careerFormSubmitBtn.click();
        waitFoWebElementToAppear(careerFormValidationMsg);

        if (careerFormValidationMsg.isDisplayed())
            System.out.println("Msg Displayed is"+" "+careerFormValidationMsg.getText());
        else
            System.out.println("Msg not Displayed");
    }


}
