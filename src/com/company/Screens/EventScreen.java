package com.company.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Darryl on 1/6/2017.
 */
public class EventScreen {
    public WebElement getAnyEventAlsoViewedLogo(ChromeDriver driver){
        WebElement anyEventAlsoViewedLogo =driver.findElement(By.className("a-carousel-card"));
        return anyEventAlsoViewedLogo;
    }

}
