package tests.day13;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.DataOutput;
import java.io.File;
import java.io.IOException;

public class C01 {


    @Test(priority = 1)
    public void loginTest() throws InterruptedException, IOException {
        QdPage qdPage=new QdPage();


        //  https://www.qualitydemy.com
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // dogru  kullanici adi ve sifresi ile  giris yapin giris yapildigini test eden ve fotograf cekin
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonuoncesiCookie.click();
        Thread.sleep(2000);
        qdPage.loginButonu.click();
        Thread.sleep(1000);

        TakesScreenshot tSs= (TakesScreenshot) Driver.getDriver();

        File basariliSonuc= new File("target/basariliSonucER.png");

        File geciData=tSs.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciData,basariliSonuc);


        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());



    }

    @Test(priority = 2)
    public void ucretTesti() throws IOException, InterruptedException {
        QdPage qdPage=new QdPage();


        // Categories bolumunde bulunan -->IT-Software-->Microsoft Certification bolumlerini secin

        Actions actions=new Actions(Driver.getDriver());

        actions.moveToElement(qdPage.categoriesIcon).perform();
        actions.moveToElement(qdPage.itSoftware).perform();
        qdPage.certification.click();
        // Categories bolumdeki basliklar dan  DISNEY MAGIC ENGLISH bulumunu secin

        qdPage.disneyEnglish.click();
        Thread.sleep(1000);

        TakesScreenshot tSs= (TakesScreenshot) Driver.getDriver();

        File ikinciEkrenG=new File("target/ikinciEkranG.jpeg");

        File geciciData=tSs.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciData,ikinciEkrenG);

        // DISNEY MAGIC ENGLISH kursunun ucretinin $400 dan daha yuksek oldugunu test edin ve ekran goruntusunu alin
        String actualUcret= qdPage.dmeUcret.getText();
        actualUcret=actualUcret.replaceAll("\\D","");
        int expectedUcret=400;
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertTrue(Integer.parseInt(actualUcret)>expectedUcret,"kursun ucreti 400 dolardan dusuktur.");



    }

    @Test(priority = 3)
    public void compareTest() throws IOException {
        QdPage qdPage=new QdPage();

        // son olarak compera bolumune tiklayarak acilan ekranda birinci secim alanina Java Kursu ikinci secim alanina da Piano
        qdPage.compare.click();
        qdPage.birincisecimalani.sendKeys("Java Kursu");
        qdPage.ikincisecimalani.sendKeys("Piano");
        // ekran goruntusunu alin

        TakesScreenshot tSs= (TakesScreenshot) Driver.getDriver();

        File ucuncuEkrenG=new File("target/ucuncuEkrenG.jpeg");

        File geciciData=tSs.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciData,ucuncuEkrenG);


        // Java Kursunun egitim seviyesinin Intermediate oldugunu test edin.
        SoftAssert softAssert=new SoftAssert();

        String actualSeviye=qdPage.seviye.getText();
        String expectedSeviye="Intermediate";

        softAssert.assertEquals(actualSeviye,expectedSeviye,"beklenen seviye karsilanamamistir.");

        softAssert.assertAll();
    }


}