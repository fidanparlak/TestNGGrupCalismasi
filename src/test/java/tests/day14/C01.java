package tests.day14;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.QdPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01 {

    QdPage qdPage=new QdPage();
    @Test
    public void test01() throws IOException {
        //  https://www.qualitydemy.com
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // dogru  kullanici adi ve sifresi ile  giris yapin fotograf cekin
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonuoncesiCookie.click();
        qdPage.loginButonu.click();
        ReusableMethods.bekle(2);

        ReusableMethods.getScreenshot("LoginCheck");


        // categories alaninda all courses bolumunu secin
        qdPage.categoriesIcon.click();
        qdPage.allCoursesSecenegi.click();
        ReusableMethods.bekle(2);

        // acilan sayfada ilk olarak IT & Software alani ve ucret bolumunde Free secilecek Level intermediate secilsin

       // qdPage.itSoftwaree.click();

      //  ReusableMethods.bekle(2);
        qdPage.dmeUcret.click();
        ReusableMethods.bekle(2);
        qdPage.secilenKursSeviye.click();


        // listenen kursun seviyesisnsn intermedite oldugunu test edin
        SoftAssert softAssert=new SoftAssert();
        String expectedSeviye="Intermedite";

        // kursa tiklayin get enroll tiklayin secimin basarili oldugunu test edin






    }
}