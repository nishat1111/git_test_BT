import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class googlehomeTest extends commonSetup{
     GoogleHome ggle;
    @BeforeMethod
    void setUpHome(){
        setup("https://www.google.com/");
       ggle= PageFactory.initElements(driver,GoogleHome.class);
    }
    @AfterMethod
    void cleanbrowser(){
        cleanup();
    }

    @Test
    void test3(){
        Assert.assertTrue(ggle.textcopy().contains("Save your passwords securely with your Google Account"));
    }

    @Test (enabled = false) // enable false means it wont run
    void test4(){
        ggle.clickOn();
    }

    @Test
    void test5(){
        ggle.search("selenium"); //passed
    }
}
//@Parameters({"browser"})
//if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("chrome")) {
//            System.setProperty();
//        } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {);
//        }
//@Parameters({"os"})
//if (os.equalsIgnoreCase("mac") ) {
//            System.setProperty();
//        } else if (os.equalsIgnoreCase("windows")) {);
//        }
//Sol IT Support6:08 PM
//<parameter name="os" value="mac"/>