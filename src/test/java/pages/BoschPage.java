package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class BoschPage {
    public BoschPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    //  cookies
    @FindBy(xpath = "//button[@class='BoschPrivacySettingsV2__close']")
    public WebElement cookiesKapatmaButon;

    @FindBy(xpath = "//span[@class='M-Main-Navigation__toggle__icon']")
    public WebElement menu;

    @FindBy(xpath = "//span[text()=' Stories']")
    public WebElement Stories;

    @FindBy(xpath = "//span[text()=' Topics']")
    public WebElement Topics;

    @FindBy(xpath = "//span[text()='Automated Driving']")
    public WebElement AutomatedDriving;


    @FindBy(xpath = "(//a[@class='M-SocialShareIcons__icon'])[9]")
    public WebElement InstagramIcon;


    @FindBy(xpath = "//*[@id=\"mount_0_0_LW\"]/div/div/div[2]/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/div/button[2]")
    public WebElement InstagramCookies;

    @FindBy(xpath = "(//span[@class='_ac2a'])[2]")
    public WebElement InstagramFolloweText;


    // driveri yeni bir tab da acin daha sonra instagram iconuna tiklayin
        // acilan instagaram sayfasinda takipci<followers> sayisisnisn 40K dan daha yuksek oldugunu test ediniz


    /* *********** POM’a uygun olarak gerekli elementleri  locate edin*************** */


}
