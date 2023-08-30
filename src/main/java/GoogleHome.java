import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class GoogleHome extends commonSetup{
    @FindBy(css ="[id=\"e6yDCfi3\"]")
    WebElement savePassword;

    @FindBy(css = "[aria-label=\"No thanks\"]")
    WebElement noThanks;

    @FindBy(css = "[title=\"Search\"]")
    WebElement searchbar;

    String textcopy(){
        driver.switchTo().frame(0);
        return savePassword.getText();
    }

    void clickOn(){
        driver.switchTo().frame(0);
        noThanks.click();
        driver.switchTo().defaultContent(); //geeting back from frame
    }
    void search(String word){

        searchbar.sendKeys(word, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
    }


}
