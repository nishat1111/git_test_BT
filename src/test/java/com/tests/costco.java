package com.tests;

import com.base.BaseTest;
import com.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class costco extends BaseTest {
    /*
    1. Open up Costco.com
2. Type “Strawberry” in the search bar
3. Filter the list by changing the dropdown menu to “Most Viewed”
            4. Add the first item in the list to the cart
    Make note of the item name and price
5. Navigate to the cart
6. Confirm the one item in the cart is the same item that was added (by verifying the item name and price)
7. Remove the item from the cart
8. Confirm the cart is now empty
*/
   // WebDriver driver;
    @Test
    public void searchItemAndAddToCart() {

        HomePage homepageObj=new HomePage(driver);
        homepageObj.enterSearchValue("Strawberry");

      //  driver.findElement(By.id("search-field")).sendKeys("Strawberry");
        driver.findElement(By.xpath("//button[@class='btn search-ico-button']")).click();

        try{
            Thread.sleep(3000);
        }catch(Exception e){}

        Select filter=new Select(driver.findElement(By.id("sort_by")));
        filter.selectByIndex(5);

        String addedProduct=driver.findElement(By.xpath("(//div[@class='product-tile-set']//span[@class='description'])[1]")).getText();
        String price =driver.findElement(By.xpath(" (//div[@class='product-tile-set']//span[@class='description'])[1]/..//div[@class='price']")).getText();



        driver.findElement(By.xpath("(//div[@class='product-tile-set']//span[@class='description'])[1]")).click();

        driver.findElement(By.id("add-to-cart-btn")).click();

        try{
            Thread.sleep(15000);
        }catch(Exception e){}
        driver.findElement(By.xpath("//div[@id='costcoModalText']//a[@href='/CheckoutCartView']")).click();

        String expectedItemName=driver.findElement(By.xpath(" //a[contains(@automation-id,'productTitleLinks')]")).getText();


        Assert.assertEquals(addedProduct,expectedItemName);

        driver.findElement(By.xpath("//span[contains(@automation-id,'removeItemLink')]")).click();
        try{
            Thread.sleep(10000);
        }catch(Exception e){}


        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Your shopping cart is empty')]")).isDisplayed());






    }


}
