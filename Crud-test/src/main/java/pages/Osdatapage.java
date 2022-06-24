package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Osdatapage extends basePage{


    @FindBy(xpath = "//*[@id='ccc-notify-accept']")
    public WebElement acceptBtn;

    @FindBy(xpath = "//span[contains(text(),'Docs')]")
    public  WebElement docs;

    @FindBy(xpath = "//h1[contains(text(),'Documentation')]")
    public  WebElement documentation;

    @FindBy(xpath = "//h3[contains(text(),'OS Downloads API')]")
    public  WebElement osDownloadapiLink;

    @FindBy(xpath = "//span[contains(text(),'OS Downloads API')]")
    public  WebElement osDownloadapisection;

    @FindBy(linkText = "OS Downloads API: Overview")
    public  WebElement osdownloadlink;



    public Osdatapage(WebDriver driver) {
        super(driver);
    }
}
