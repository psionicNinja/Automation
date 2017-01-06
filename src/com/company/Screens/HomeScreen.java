package com.company.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Created by Darryl on 1/6/2017.
 */
public class HomeScreen {

    public WebElement getSearchTextBox(ChromeDriver driver){
        WebElement searchTextBox=driver.findElement(By.id("tickets-search-input"));
        return searchTextBox;
    }


    public WebElement getSearchSubmitButton(ChromeDriver driver){
        WebElement searchSubmitButton=driver.findElement(By.className("a-button-input"));
        return searchSubmitButton;
    }
}
