import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Alert extends commonSetup{
@FindBy(xpath = "//button[@id=\"confirmButton\"]")
    WebElement alertButton;
@FindBy(className = "mr-3")
WebElement alertText;

void acceptAlert(){
    alertButton.click();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit wait
    driver.switchTo().alert().accept();
}
String getTextAlert(){
    return alertText.getText();
}
}
