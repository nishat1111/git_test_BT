package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SeleniumBasic {
public static WebDriver driver;



    public static void setup(String url){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(url);
    }

@BeforeTest
    public static void navigateTo() {
        setup("https://www.letskodeit.com/practice");
    }

   static void close() {
        driver.close();
    }



    public static void amazonTest() throws InterruptedException {
        waitFor(1);  // wait 1 sec

    }

    static void waitFor(int second) throws InterruptedException {
        Thread.sleep(1000*second);
    }





    @Test
    public void testTabHandle() throws InterruptedException {
        setup("https://www.letskodeit.com/practice");
        //System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[@id='opentab']")).click();
        driver.findElement(By.xpath("//a[@id='opentab']")).click();
        waitFor(3);
       System.out.println(driver.getTitle());
       String mainTab = driver.getWindowHandle();
        List<String> childTabs = new ArrayList<String>(driver.getWindowHandles());

      // childTabs= {"window1","window2","window3"};
        //childTabs.remove(mainTab);
        driver.switchTo().window(childTabs.get(2));
        System.out.println( driver.getTitle());
        System.out.println( driver.getCurrentUrl());
        driver.switchTo().window(childTabs.get(0));
        System.out.println( driver.getTitle());
        System.out.println( driver.getCurrentUrl());
    }





    public void scroll(int horizontal, int vertical) {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        String script = "window.scrollBy(" + horizontal + "," + vertical + ")";
        //String script1="window.scrollBy(200,300)";
        scroll.executeScript(script);
    }
@Test
public void testScroll(){
   scroll(0,500);
}




    @Test
    public void mouseHover() throws IllegalArgumentException,InterruptedException {
    WebElement element =driver.findElement(By.xpath("//button[@id='mousehover']"));
    scroll(0, 500);
    Actions action = new Actions(driver);
    action.moveToElement(element).perform();
    waitFor(3);
    }




    public void selectFromDropByValue(String locator, String visibleText) {
        WebElement element = driver.findElement(By.xpath(locator));
        Select drpWrd = new Select(element);
        drpWrd.selectByVisibleText(visibleText);
    }

    @Test
    void dropdownTest() {
        WebElement element= driver.findElement(By.xpath("//select[@id='carselect']"));
        Select obj=new Select(element);
        obj.selectByVisibleText("Benz");

    }

   // If we list all the natural numbers below 10 that are multiples of 3 or 7, we get 3, 6, 7 and 9. The sum of these multiples is 25. What is the sum of multiples of 3, 7 for the natural numbers below 1000?


    //    Select From Multiple Menu
//    public void selectFromMultipleDrop(String locator1, String locator2, String locator3){
//        WebElement element = driver.findElement(By.xpath(locator1));
//        Select drpWrd = new Select(element);
//        drpWrd.selectByValue(locator2);
//        drpWrd.selectByValue(locator3);
//    }
    @Test
    public void testDropDown() throws InterruptedException {

        selectFromDropByValue("//select[@id='carselect']", "Benz");
waitFor(5);
driver.close();
    }
















    public static void main(String[] args) throws InterruptedException{

//setup("https://www.amazon.com/");
//waitFor(1);  // wait 1 sec
//close();

//setup("https://www.google.com/");
//waitFor(3); // wait 3 sec
//close();
//setup("https://www.td.com/");
//waitFor(5); // wait 5 sec
//close();



    }
}
