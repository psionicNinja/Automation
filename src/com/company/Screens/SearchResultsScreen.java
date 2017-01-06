package com.company.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Darryl on 1/6/2017.
 */
public class SearchResultsScreen {

    public WebElement getAnySearchResult(ChromeDriver driver){
        WebElement anySearchResult=driver.findElement(By.className("card-figure-content"));
        return anySearchResult;
    }
}
