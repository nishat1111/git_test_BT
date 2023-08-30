import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class homePage extends commonSetup {
    @FindBy(css = "[placeholder=\"Search for anything\"]")
    WebElement searchBox;

    @FindBy(css = "[type=\"submit\"]")
    WebElement searchButton;

    @FindBy(css = "[class=\"srp-controls__count-heading\"]")
    WebElement searchResult;

    @FindBy (css="[title=\"My eBay\"]")
    WebElement myebay;
    @FindBy(xpath = "//ul[@id=\"gf-l\"]/li[5]")
    WebElement sellerCenter; //parent child
    @FindBy(className = "gh-p")
    WebElement dailyDeals;
    @FindBy(id = "gh-as-a")
    WebElement advanced;
    @FindBy(xpath = "//ul[@class=\"hl-cat-nav__container\"]/li[4]/a") //parent child
    WebElement electronics;
    @FindBy(xpath = "//a[contains(text(),'Score these trending kicks')]") //text xpath
    WebElement containsText;
    @FindBy(css = "[class=\"gh-sb \"]") // dropdown
    WebElement allCategory;
    @FindBy(css ="[class=\"gf-bttl\"]") //list of elements // didnt use
    WebElement tools;
    @FindBy(xpath = "//*[@id=\"personalized_events1\"]/div[1]/h2/a/div/span")
    WebElement textCopy;
    @FindBy(xpath = "//*[@id=\"destinations_list1\"]/div/div/div[1]/h2/a")
    WebElement trendingKicks;
    @FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div/ul/li[1]/div/div[1]/div/div[2]/a/div[2]")
    WebElement getgpoing; // relative xpath


    void searchProduct(String product){
        searchBox.sendKeys(product);
    }
    void clickSearch(){
        searchButton.click();
    }
    String searchText(){
        return searchResult.getText();
    }
    void clickmyebay (){
        myebay.click();}
    boolean MyEbayCheck(){
        return myebay.isDisplayed();
    }
    String MyEbayText(){
        return myebay.getText();
    }

    void clicksellerCenter(){
        Actions actions=new Actions(driver);
        actions.scrollToElement(sellerCenter).build().perform();
        sellerCenter.click(); //failed
    }
    String dailydealsText(){
        return dailyDeals.getAccessibleName(); // didnt understand
    }
    void clickAdvanced(){

        advanced.click();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
    }
    void clickElectronics(){
        electronics.click();
    }
    String textXpath(){
        return containsText.getText();
    }
    void selectCategory(){
        Select select=new Select(allCategory);
        select.selectByIndex(4);
       // select.deselectByVisibleText("books");//not working
       // select.deselectByValue("58058"); not working
    }
    void webdriverWait(){
        Actions actions=new Actions(driver);
        actions.moveToElement(textCopy).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[@id=\"personalized_events1\"]/div[1]/h2/a/div/span")));
      textCopy.click();
    }
    void clickTrendingKicks(){
        Actions actions=new Actions(driver);
        actions.contextClick(trendingKicks).build().perform();
        trendingKicks.click();
    }
    void clicktools(){
      //  List<WebElement>
    }




}




