package com.company.Screens;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Darryl on 1/6/2017.
 */
public class EventScreen {
    private ChromeDriver mDriver;

    public EventScreen(ChromeDriver driver) {
        mDriver=driver;
    }

    public WebElement getAnyEventAlsoViewedLogo(){
        WebElement anyEventAlsoViewedLogo =mDriver.findElement(By.className("a-carousel-card"));
        return anyEventAlsoViewedLogo;
    }

}
