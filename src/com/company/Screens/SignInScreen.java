package com.company.Screens;

import com.company.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Darryl on 1/6/2017.
 */
public class SignInScreen {

    private ChromeDriver mDriver;
    public SignInScreen(ChromeDriver driver) {
        mDriver=driver;
    }
    public WebElement getSignInUserNameTextBox(){
        WebElement signInTextBox =mDriver.findElement(By.id("ap_email")) ;
        return signInTextBox;
    }

    public WebElement getSignInPasswordTextBox(){
        WebElement passwordTextBox =mDriver.findElement(By.id("ap_password")) ;
        return passwordTextBox;
    }

    public WebElement getSignInButton() {
        WebElement getSignInButton =mDriver.findElement(By.id("signInSubmit-input"));
        return getSignInButton;
    }

    public Boolean isLoaded() {

        return getSignInButton().isDisplayed();
    }
}
