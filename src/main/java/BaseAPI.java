
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class BaseAPI {


    WebDriver driver;

    public void navigateToUrl(String url) {
        System.setProperty("webdriver.chrome.driver", "//chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

   // @AfterMethod(alwaysRun = true)
    public void closeAllTab() {
        driver.quit();
    }

    /*===============================Close current tab====================================*/

    public void closeCurrentTab() {
        driver.close();
    }

    /*===============================Navigate to Letskodeit====================================*/

    public void navigateToLetskodeit() {

        navigateToUrl("https://learn.letskodeit.com/p/practice");
    }

    /*===============================PageFactory approch====================================*/


    public void getInitElement() {
        PageFactory.initElements(driver, BaseAPI.class);
    }


    /*===============================Sleep method WebAPI====================================*/

    public void sleepFor(int second) throws InterruptedException {
        Thread.sleep(1000 * second);
    }

    /*===============================Implicit Wait WebAPI====================================*/


    public void waitImplicit(int second) {

        driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }

    /*===============================Navigate Forward====================================*/


    public void navigateForward() {
        driver.navigate().forward();
    }

    /*=============================== click / RadioButton / checkBox====================================*/


    public void clickOn(String locator) {
        try {
            driver.findElement(By.xpath(locator)).click();
        } catch (Exception e) {
            try {
                driver.findElement(By.cssSelector(locator)).click();
            } catch (Exception e1) {
                try {
                    driver.findElement(By.id(locator)).click();
                } catch (Exception e2) {
                    try {
                        driver.findElement(By.name(locator)).click();
                    } catch (Exception e3) {
                        try {
                            driver.findElement(By.className(locator)).click();
                        } catch (Exception e4) {
                            try {
                                driver.findElement(By.linkText(locator)).click();
                            } catch (Exception e5) {
                                try {
                                    driver.findElement(By.partialLinkText(locator)).click();
                                } catch (Exception e6) {
                                    driver.findElement(By.tagName(locator)).click();
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    // click WEBAPI method 2 (pageFactory)

   /* public void clickOn(WebElement element) {
        element.click();
    } */

    //test click

    public static final String ab = "//a[@id='header-sign-up-btn']";

    @Test
    public void testclick() {
        navigateToLetskodeit();
        clickOn(ab);
    }

    /*===============================Only send key====================================*/

    public void sendKey(String locator, String value) {
        makeWebElement(locator).sendKeys(value);
    }

    //SendKeys for page factory

      /* public void typeInsideBox(WebElement element, String value) {
      element.sendKeys(value);
      } */

    /*===============================SEND KEYS & Enter====================================*/

   /* PageFactory Approch

   public void typeSearchBarNEnter(String locator, String value) {
        makeWebElement(locator).sendKeys(value, Keys.ENTER);
    } */

    public void sendKeyNEnter(String locator, String value) {
        try {
            driver.findElement(By.xpath(locator)).sendKeys(value, Keys.ENTER);
        } catch (Exception e) {
            try {
                driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.ENTER);
            } catch (Exception e1) {
                try {
                    driver.findElement(By.id(locator)).sendKeys(value, Keys.ENTER);
                } catch (Exception e2) {
                    try {
                        driver.findElement(By.name(locator)).sendKeys(value, Keys.ENTER);
                    } catch (Exception e3) {
                        try {
                            driver.findElement(By.className(locator)).sendKeys(value, Keys.ENTER);
                        } catch (Exception e4) {
                            try {
                                driver.findElement(By.linkText(locator)).sendKeys(value, Keys.ENTER);
                            } catch (Exception e5) {
                                try {
                                    driver.findElement(By.partialLinkText(locator)).sendKeys(value, Keys.ENTER);
                                } catch (Exception e6) {
                                    driver.findElement(By.tagName(locator)).sendKeys(value, Keys.ENTER);
                                }
                            }
                        }
                    }
                }
            }
        }

    }


    @Test
    public void testSendKey() throws InterruptedException {
        String sendKeyXP = "//input[@id='user_name']";
        testclick();
        sleepFor(2);
        sendKeyNEnter(sendKeyXP, "hdjhfhsh");
        sleepFor(2);
    }

    /*===============================Send Key Clear field====================================*/

    public void clearField(String locator) {
        try {
            driver.findElement(By.xpath(locator)).clear();
        } catch (Exception e) {
            try {
                driver.findElement(By.cssSelector(locator)).clear();
            } catch (Exception e1) {
                try {
                    driver.findElement(By.id(locator)).clear();
                } catch (Exception e2) {
                    try {
                        driver.findElement(By.name(locator)).clear();
                    } catch (Exception e3) {
                        try {
                            driver.findElement(By.className(locator)).clear();
                        } catch (Exception e4) {
                            try {
                                driver.findElement(By.linkText(locator)).clear();
                            } catch (Exception e5) {
                                try {
                                    driver.findElement(By.partialLinkText(locator)).clear();
                                } catch (Exception e6) {
                                    driver.findElement(By.tagName(locator)).clear();
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /*===============================get CurrentPageURL in Console====================================*/

    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }


    @Test
    public void drr() {
        navigateToLetskodeit();
        getCurrentPageUrl();
        System.out.println(getCurrentPageUrl());
    }

    /*===============================sendKye by Array search one after one====================================*/


    public void searchFromArray(String[] array, String url, String locatorOfCurrentDomain) throws InterruptedException {
        navigateToUrl(url);
        /* navigateToUrl("https://www.google.com/");  */
        for (String searchWord : array) {
            driver.findElement(By.xpath(locatorOfCurrentDomain)).sendKeys(searchWord, Keys.ENTER);
            sleepFor(2);
            System.out.println(driver.getTitle());

            driver.navigate().back();
        }
    }

    @Test
    public void testSearchFromArray() throws InterruptedException {
        String[] fashion = {"Shirt", "Pant", "Shoe", "Belt", "Hand Bag"};
        String googleUrl = "https://www.google.com/";
        String xpathOfGoogleSearch = "//input[@name='q']";

        String[] grocery = {"egg", "coffee", "milk", "cheese", "bean"};
        String amazonUrl = "https://www.amazon.com/";
        String xpathOfAmazonSearch = "//input[@id='twotabsearchtextbox']";

        searchFromArray(fashion, googleUrl, xpathOfGoogleSearch);
        searchFromArray(grocery, amazonUrl, xpathOfAmazonSearch);
    }

    /*===============================New Tabs Handling====================================*/

    public WebDriver handleNewTab(WebDriver driver1) {
        String mainTab = driver1.getWindowHandle();
        List<String> childTabs = new ArrayList<String>(driver1.getWindowHandles());
        childTabs.remove(mainTab);
        driver1.switchTo().window(childTabs.get(0));
        return driver1;
    }

    @Test
    public void testTabHandle() throws InterruptedException {
        navigateToLetskodeit();
        System.out.println(driver.getTitle());
        clickOn("//a[@id='opentab']");
        sleepFor(3);
        System.out.println(driver.getTitle());
        handleNewTab(driver);
        System.out.println(driver.getTitle());
        driver.close();

    }
    /*===============================test windows handle====================================*/


    public WebDriver handleNewWindow(WebDriver driver1) {
        String mainWindow = driver1.getWindowHandle();
        List<String> childWindows = new ArrayList<String>(driver1.getWindowHandles());
        childWindows.remove(mainWindow);
        driver1.switchTo().window(childWindows.get(0));
        return driver1;
    }

    @Test
    public void testWindowHandle() throws InterruptedException {
        navigateToLetskodeit();
        System.out.println(driver.getTitle());
        clickOn("//button[@id='openwindow']");
        sleepFor(2);
        System.out.println(driver.getTitle());
        handleNewWindow(driver);
        System.out.println(driver.getTitle());
        driver.close();
    }

    /*===============================Make all the "Xp, css, id, name, class name, LinkText, partialTEXT and tag name" as a WebElement.
  So we don't have to make them as a WebElement. Because This method make them already Webelement. SO we can
  use the pageFactory Approach for all other method.====================================*/

    public WebElement makeWebElement(String locator) {
        WebElement element;
        try {
            element = driver.findElement(By.xpath(locator));
            return element;
        } catch (Exception e) {
            try {
                element = driver.findElement(By.cssSelector(locator));
                return element;
            } catch (Exception e1) {
                try {
                    element = driver.findElement(By.id(locator));
                    return element;
                } catch (Exception e2) {
                    try {
                        element = driver.findElement(By.name(locator));
                        return element;
                    } catch (Exception e3) {
                        try {
                            element = driver.findElement(By.className(locator));
                            return element;
                        } catch (Exception e4) {
                            try {
                                element = driver.findElement(By.linkText(locator));
                                return element;
                            } catch (Exception e5) {
                                try {
                                    element = driver.findElement(By.partialLinkText(locator));
                                    return element;
                                } catch (Exception e6) {
                                    element = driver.findElement(By.tagName(locator));
                                    return element;
                                }
                            }
                        }
                    }
                }
            }
        }


    }

    /*===============================Mouse Hover====================================*/

    public void mouseHover(String locator) {
        try {
            WebElement element = makeWebElement(locator);
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = makeWebElement(locator);
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }

    @Test
    public void testMouseHover() throws InterruptedException {
        navigateToUrl("https://learn.letskodeit.com/p/practice");
        scroll(0, 600);
        //mouseHover("#mousehover");
        mouseHover("//button[@id='mousehover']");
        sleepFor(5);
    }

    /*=============Scroll up and down, right and left. HORIZONTAL Scroll and Vertical scroll================*/


   /* public void scrollUpDown(int scroll){
        JavascriptExecutor Scroll = (JavascriptExecutor) driver;
        Scroll.executeScript("window.scrollBy(0,"+scroll+")");
    } */

    public void scroll(int horizontal, int vertical) {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        String script = "window.scrollBy(" + horizontal + "," + vertical + ")";
        //String script1="window.scrollBy(200,300)";
        scroll.executeScript(script);
    }

    /*===============================Drop down Single Select====================================*/

    public void selectFromDropByValue(String locator, String visibleText) {
        WebElement element = makeWebElement(locator);
        Select drpWrd = new Select(element);
        drpWrd.selectByVisibleText(visibleText);
    }

    //    Select From Multiple Menu
//    public void selectFromMultipleDrop(String locator1, String locator2, String locator3){
//        WebElement element = driver.findElement(By.xpath(locator1));
//        Select drpWrd = new Select(element);
//        drpWrd.selectByValue(locator2);
//        drpWrd.selectByValue(locator3);
//    }
    @Test
    public void testDropDown() throws InterruptedException {
        navigateToUrl("https://learn.letskodeit.com/p/practice");
        selectFromDropByValue("//select[@id='carselect']", "BMW");
        sleepFor(5);
    }

    /*===============================Drop down multiple Select====================================*/


    public void selectOneByOneDropDownElementFromArray(String[] array, String locator) {
        for (String visibleText : array) {
            selectFromDropByValue(locator, visibleText);
            System.out.println(visibleText);
            // sleepFor(2);
        }
    }

    @Test
    public void testDropDownItemFromArray() throws InterruptedException {
        String[] listVisibleText = {"Auto", "ATV", "Condo", "RV", "Flood", "Travel", "Pet", "Life", "Umbrella", "Landlord"};
        navigateToUrl("https://www.geico.com/");
        selectOneByOneDropDownElementFromArray(listVisibleText, "//select[@id='homepage_manage_select']");
        sleepFor(2);
    }

    /*===============================Single Select or multiple Select====================================*/

    public void selectOneByOneSelectMenuFromArray(String[] array, String locator) {
        for (String visibleText : array) {
            selectFromDropByValue(locator, visibleText);
            System.out.println(visibleText);
            // sleepFor(2);
        }
    }

    @Test
    public void testSelectItemfromArray() throws InterruptedException {
        String[] listVisibleText = {"Apple", "Peach"};
        //navigateToUrl("https://learn.letskodeit.com/p/practice");
        navigateToLetskodeit();
        selectOneByOneDropDownElementFromArray(listVisibleText, "//select[@id='multiple-select-example']");
        sleepFor(2);

    }

    /*======================================Alert Handle==========================================*/

    // Ok Alart
    public void okAlert() {
        driver.switchTo().alert().accept();
    }

    // Dismiss alart
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void testAlert() throws InterruptedException {
        navigateToLetskodeit();
        scroll(0, 700);
        String alertSendKey = "Zahid"; //declare and initialize send key value for alert box
        String expectedTextFromAlert = "Hello " + alertSendKey + ", Are you sure you want to confirm?";
        sendKey("//input[@id='name']", alertSendKey); //call send key method and put two parameter
        sleepFor(2);
        clickOn("//input[@id='confirmbtn']");// click for generate alert
        sleepFor(1);
        String actualTextFromAlart = driver.switchTo().alert().getText(); // get actual text of alert.
        Assert.assertEquals(actualTextFromAlart, expectedTextFromAlert); // assert or verify the alert text
        sleepFor(3);
        okAlert(); // click ok button on alert.
    }
    /*======================================Screenshot capture==========================================*/


    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        DateFormat df = new SimpleDateFormat("(MM.dd.yyyy-HH:mma)");
        Date date = new Date();
        df.format(date);

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,
                    new File(System.getProperty("user.dir") + "/Screenshots/" + screenshotName + " " + df.format(date) + ".png"));
            System.out.println("Screenshot captured");
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot " + e.getMessage());
        }
    }

    /*=====================Hide & Show Handle. Need "sendKey, clickOn & captureScreenShot"=======================*/
    @Test
    public void testShowHide() {
        navigateToLetskodeit();
        sendKey("//input[@id='displayed-text']", "kollol");
        clickOn("//input[@id='hide-textbox']"); // click on hide button
        captureScreenshot(driver, "HideTheTextBox");
        clickOn("//input[@id='show-textbox']"); // // click on show button
        captureScreenshot(driver, "ShowTheTextBox");
    }


    /*==================================iFrame Handle====================================*/

    public void goInsideIframe(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void goBackToHomeWindow() {
        driver.switchTo().defaultContent();
    }

    @Test
    public void testHandleIframe() throws InterruptedException {
        navigateToLetskodeit();
        scroll(0, 1300);
        sleepFor(3);
        WebElement element = makeWebElement("//iframe[@id='courses-iframe']");
        goInsideIframe(element);
        sleepFor(5);
        scroll(0, 1000);
        sleepFor(3);
        goBackToHomeWindow();
    }

    /*==================================Web Table Handle====================================*/
    @Test
    public void testWebTable() throws InterruptedException {
        navigateToLetskodeit();
        scroll(0, 600);
        sleepFor(3);

        //*[@id="product"]/tbody/tr[2]/td[2]
        //*[@id="product"]/tbody/tr[3]/td[2]
        //*[@id="product"]/tbody/tr[4]/td[2]


        //*[@id="product"]/tbody/tr[2]/td[3]
        //*[@id="product"]/tbody/tr[3]/td[3]
        //*[@id="product"]/tbody/tr[4]/td[3]

        //*[@id="product"]/tbody/tr[2]/td[3]

        String beforeXpath = "//*[@id=\"product\"]/tbody/tr[";
        String afterXpath = "]/td[2]";

        for (int i = 2; i <= 4; i++) {
            String actualXpath = beforeXpath + i + afterXpath;
            WebElement element = driver.findElement(By.xpath(actualXpath));

            String text = element.getText();
            System.out.println("Course name is: " + text + "position in the table is: " + (i - 1) + ".");
            sleepFor(3);

        }


    }


    @Test
    public void switchWindow() throws InterruptedException {
        navigateToLetskodeit();
        driver.findElement(By.xpath("//button[@id='openwindow']")).click(); //Window open
        Thread.sleep(2000);
        Set<String> windowIds = driver.getWindowHandles();  // collect all window ids inside the set
        Iterator<String> iter = windowIds.iterator(); // iterate all windowsIds one after one

        String mainWindow = iter.next();  // get the first/main window
        String childWindow = iter.next();  // then get the next/child window

        driver.switchTo().window(childWindow); // move to chid window
        System.out.println("The title of the child window : " + driver.getTitle());
        driver.close();
        Thread.sleep(2000);
        driver.switchTo().window(mainWindow); // move to main window
        System.out.println("The title of the main window : " + driver.getTitle());
        driver.close();
    }

    @Test(priority = 2)
    public void switchTab() throws InterruptedException {
        navigateToLetskodeit();
        driver.findElement(By.xpath("//a[@id='opentab']")).click(); //Window open
        sleepFor(3);
        Set<String> windowId = driver.getWindowHandles();  // collect all window ids inside the set
        Iterator<String> itere = windowId.iterator(); // iterate all windowsIds one after one

        String mainWindows = itere.next();  // get the first/main window
        String childWindows = itere.next();  // then get the next/child window

        driver.switchTo().window(childWindows); // move to chid window
        System.out.println("The title of the child window : " + driver.getTitle());
        driver.close();
        sleepFor(3);
        driver.switchTo().window(mainWindows); // move to main window
        System.out.println("The title of the main window : " + driver.getTitle());
        driver.close();


    }


}

