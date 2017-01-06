package com.company.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Created by Darryl on 1/6/2017.
 */
public class HomeScreen {

    private ChromeDriver mDriver;
    public HomeScreen(ChromeDriver driver) {
        mDriver=driver;
    }
    public WebElement getSearchTextBox(){
        WebElement searchTextBox=mDriver.findElement(By.id("tickets-search-input"));
        return searchTextBox;
    }


    public WebElement getSearchSubmitButton(){
        WebElement searchSubmitButton=mDriver.findElement(By.className("a-button-input"));
        return searchSubmitButton;
    }
}
