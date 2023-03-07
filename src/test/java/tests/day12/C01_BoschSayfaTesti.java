package tests.day12;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BoschPage;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

public class C01_BoschSayfaTesti {
    BoschPage bosch=new BoschPage();

    @Test
    public void test01() throws IOException {

        // https://www.bosch.com/ adresine gidin
        Driver.getDriver().get("https://www.bosch.com/");

        // varsa cookies kabul/veya reddedin

        bosch.cookiesKapatmaButon.click();

        // bosch ana sayfasinda oldugunuzu test edin
        String expectedIfade="Bosch";
        String actualTitle=Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedIfade));

        // menu--> Stories-->Topics-->Automated driving tiklayin
        bosch.menu.click();
        bosch.Stories.click();
        bosch.Topics.click();
        bosch.AutomatedDriving.click();

        // sayfanin en altina gelin ve buranin screenshot unu alin
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();

        TakesScreenshot tSs= (TakesScreenshot) Driver.getDriver();

        File sayfaSonuSs=new File("target/boschSs.jpeg");

        File geciciData=tSs.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciData,sayfaSonuSs);


    }

    @Test
    public void test02(){
        // driveri yeni bir tab da acin daha sonra instagram iconuna tiklayin
        bosch.InstagramIcon.click();
       bosch.InstagramCookies.click();

        String takipciSayisi=bosch.InstagramFolloweText.getText();
        // acilan instagaram sayfasinda takipci<followers> sayisisnisn 40K dan daha yuksek oldugunu test ediniz
        int actualtakipciS=Integer.parseInt(takipciSayisi);
        int expectedTakipciS=40;

        Assert.assertTrue(actualtakipciS>expectedTakipciS);



        /* *********** POM’a uygun olarak gerekli elementleri  locate edin*************** */

        Driver.quitDriver();
    }
 }