package com.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(id="search-field")
    WebElement searchbox;

    public void enterSearchValue(String val){
        searchbox.clear();
        searchbox.sendKeys(val);
    }

}
