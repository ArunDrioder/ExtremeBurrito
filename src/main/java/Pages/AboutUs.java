package Pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AboutUs extends AbstractComponent
{
    WebDriver driver;

    @FindBy(xpath = "//h5[normalize-space()='about us']")
    WebElement aboutUsTitle;

    @FindBy(xpath = "//p[contains(text(),'Extreme Burrito opened')]")
    WebElement aboutUsPrimaryContent;

    @FindBy(xpath = "//p[contains(text(),'Guests are taken on a culinary whirlwind with the ')]")
    WebElement aboutUsSecondaryContent;

    @FindBy(xpath = "//h5[normalize-space()='Vision']")
    WebElement visionTitle;

    @FindBy(xpath = "//p[contains(text(),'Extreme Burrito thrives to be the go to quick serv')]")
    WebElement visionContent;

    @FindBy(xpath = "//h5[normalize-space()='Core Values']")
    WebElement coreValuesTitle;

    @FindBy(xpath = "//p[contains(text(),'Serve our guests with Speed, Quality, Quantity and')]")
    WebElement coreValueContent;

    public AboutUs(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyAboutUs()
    {
        System.out.println("The title is:" + " "+aboutUsTitle.getText());
        System.out.println(aboutUsPrimaryContent.getText());
        System.out.println(aboutUsSecondaryContent.getText());
    }

    public void verifyVision()
    {
        scrollIntoViewIfNeeded(visionTitle);
        System.out.println("The title is:" +" "+visionTitle.getText());
        scrollIntoViewIfNeeded(visionContent);
        waitFoWebElementToAppear(visionContent);
        System.out.println(visionContent.getText());
    }

    public void verifyCoresValues()
    {
        scrollIntoViewIfNeeded(coreValuesTitle);
        waitFoWebElementToAppear(coreValuesTitle);
        System.out.println("The title is:"+" "+coreValuesTitle.getText());
        scrollIntoViewIfNeeded(coreValueContent);
        waitFoWebElementToAppear(coreValueContent);
        System.out.println(coreValueContent.getText());
    }




}
