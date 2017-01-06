package com.company.Screens;

import com.company.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Darryl on 1/6/2017.
 */
public class SignInScreen {

    public WebElement getSignInUserNameTextBox(ChromeDriver driver){
        WebElement signInTextBox =driver.findElement(By.id("ap_email")) ;
        return signInTextBox;
    }

    public WebElement getSignInPasswordTextBox(ChromeDriver driver){
        WebElement passwordTextBox =driver.findElement(By.id("ap_password")) ;
        return passwordTextBox;
    }

    public WebElement getSignInButton(ChromeDriver driver) {
        WebElement getSignInButton =driver.findElement(By.id("signInSubmit-input"));
        return getSignInButton;
    }

    public Boolean isLoaded(ChromeDriver driver) {

        return getSignInButton(driver).isDisplayed();
    }
}
