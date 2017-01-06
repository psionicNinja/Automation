package com.company;

import com.company.Screens.HomeScreen;
import com.company.Screens.SignInScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        //set arg as location to chromedriver
        //set arg as report output location
        Path filee = Paths.get("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", filee.toString());
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://tickets.amazon.co.uk/signin");
        String username= "ticketsuk34@gmail.com";
        String password ="Tick3t$!";

        //Get Sign In textBox and input credentials

        SignInScreen signInScreen = new SignInScreen();
        HomeScreen homeScreen = new HomeScreen();
        Utilities utility = new Utilities();

        signInScreen.isLoaded(driver);
        signInScreen.getSignInUserNameTextBox(driver).sendKeys(username);
        signInScreen.getSignInPasswordTextBox(driver).sendKeys(password);
        signInScreen.getSignInButton(driver).click();

        WebElement mainSearchBox=driver.findElement(By.id("tickets-search-input"));
        mainSearchBox.sendKeys("show");

        WebElement button=driver.findElement(By.className("a-button-input"));
        button.click();

        WebElement showSelect=driver.findElement(By.className("card-figure-content"));
        showSelect.click();

        WebElement showSuggestions =driver.findElement(By.className("a-carousel-card"));
        showSuggestions.click();

        ArrayList<String> textToCheckFor = new ArrayList<>();

        textToCheckFor.add(username);
        textToCheckFor.add("London");
        textToCheckFor.add("Event description");
        textToCheckFor.add("Event details");
        textToCheckFor.add("Customers who viewed this event also viewed");

        //List of results
        HashMap<String,Boolean> results = utility.checkForStrings(driver,textToCheckFor);
        try {
            utility.printResults(results);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();

    }

}
