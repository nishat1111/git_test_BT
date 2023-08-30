import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class alertTest extends commonSetup{

    Alert alt;
    @BeforeMethod
    void setUpHome(){
        setup("https://demoqa.com/alerts");
        alt= PageFactory.initElements(driver,Alert.class);
    }

    @Test
    void test13(){
        alt.acceptAlert(); // failed
    }
    @Test
    void test14(){
        alt.getTextAlert();
    }
}
