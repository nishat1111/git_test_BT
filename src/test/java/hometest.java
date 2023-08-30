import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class hometest extends commonSetup{
    homePage home;
    @BeforeMethod
    void setUpHome(){
        setup("https://www.ebay.com/");
        home= PageFactory.initElements(driver,homePage.class);

    }
    @Test //(priority = 0,enabled = true)
    void test1(){
        String product="pillow";
        home.searchProduct(product);
        home.clickSearch();
        Assert.assertTrue(home.searchText().contains(product)); //passed
         //Assert.assertEquals(home.searchText(),product); // failed
    }

    @Test
    void test2(){
        home.clickmyebay();
        System.out.println(driver.getCurrentUrl()); // passed but  facing prb last line
        Assert.assertEquals(driver.getCurrentUrl(),"https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&ru=https%3A%2F%2Fwww.ebay.com%2Fmys%2Fhome%3Fsource%3DGBH");
    } // string,int or anything we use assert equals
    @Test
    void test6(){
        boolean a= home.MyEbayCheck();
        Assert.assertTrue(a,"myebay");//passed
       // Assert.assertTrue(a); // failed
     //   Assert.assertEquals(a,"true");//failed
// boolean we use assert true/false
    }
    @Test
    void test7(){
        home.clicksellerCenter();//failed
    } // exc; driver must be set

    @Test
    void test8(){
        home.dailydealsText();
    }
    @Test
    void test9(){
        home.clickAdvanced();
    }
    @Test
    void test10(){
        home.clickElectronics();

    }
    @Test //(priority = 3)
    void test11(){
        home.textXpath(); //no text printed
    }

    @Test
    void test12(){
        home.selectCategory();
      //  System.out.println(driver.);//how to click the selected category
    }
    @Test
    void test15(){
        home.webdriverWait(); } //failed

    @Test
    void test16(){
        home.clickTrendingKicks();

    }


}
