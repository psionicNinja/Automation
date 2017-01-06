package com.company;

import com.company.Screens.EventScreen;
import com.company.Screens.HomeScreen;
import com.company.Screens.SearchResultsScreen;
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

        Path filee = Paths.get("chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", filee.toString());
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://tickets.amazon.co.uk/signin");
        String username= "ticketsuk34@gmail.com";
        String password ="Tick3t$!";


        SignInScreen signInScreen = new SignInScreen(driver);
        HomeScreen homeScreen = new HomeScreen(driver);
        SearchResultsScreen searchResultsScreen = new SearchResultsScreen(driver);
        EventScreen eventScreen = new EventScreen(driver);
        Utilities utility = new Utilities();


        //Check to see if we're on the expected sign in page, if we're not, abort the test. There's no point in proceeding

        if(!signInScreen.isLoaded()){

            /*Ideally, I'd create a separate logging method within the utility class for this, but for the sake of time,
            I'm just reusing the one from the bottom.
            */
            ArrayList<String> wtFailure = new ArrayList<>();

            wtFailure.add("Sign in screen failed to load as expected. Test aborted.");
            HashMap<String,Boolean> results = utility.checkForStrings(driver,wtFailure);
            try {
                utility.printResults(results);
            } catch (IOException e) {
                e.printStackTrace();
            }

            driver.quit();
            System.exit(1);
        }

        //Starts on the sign in screen and inputs credentials
        signInScreen.getSignInUserNameTextBox().sendKeys(username);
        signInScreen.getSignInPasswordTextBox().sendKeys(password);
        signInScreen.getSignInButton().click();

        //Land on home screen and start a search. I chose 'show' because it consistently produces a large number of results
        homeScreen.getSearchTextBox().sendKeys("show");
        homeScreen.getSearchSubmitButton().click();

        //Click any search result.
        searchResultsScreen.getAnySearchResult().click();

        //Click on any suggested show. The aim is to force a scroll action and interact with the bottom of the page.
        eventScreen.getAnyEventAlsoViewedLogo().click();

        //Verify the needed headers are being displayed.
        ArrayList<String> textToCheckFor = new ArrayList<>();


        textToCheckFor.add(username);
        textToCheckFor.add("London");
        textToCheckFor.add("Event description");
        textToCheckFor.add("Event details");
        textToCheckFor.add("Customers who viewed this event also viewed");

        //Write the test results to file
        HashMap<String,Boolean> results = utility.checkForStrings(driver,textToCheckFor);
        try {
            utility.printResults(results);
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();

    }

}
