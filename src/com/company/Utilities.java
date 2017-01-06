package com.company;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by Darryl on 1/6/2017.
 */
public class Utilities {

    public HashMap<String,Boolean> checkForStrings(ChromeDriver driver, ArrayList<String> listOfStrings) {

        HashMap<String,Boolean> results = new HashMap<>();
        for(int i=0; i<=listOfStrings.size()-1; i++) {
            if(driver.getPageSource().contains(listOfStrings.get(i))) {

                results.put(listOfStrings.get(i),true);
            }
            else
            {
                results.put(listOfStrings.get(i),false);
            }
        }
        return results;
    }

    public void printResults(HashMap<String,Boolean> results) throws IOException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        Path filee = Paths.get("testResults.txt");
        String currentLine="";
        for(String test: results.keySet()) {
            try {
                currentLine =dateFormat.format(date)+" : "+ test + " : "+ String.valueOf(results.get(test)+ System.lineSeparator());
                Files.write(filee,currentLine.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String footer="***********************TEST END**********************************"+ System.lineSeparator();
        Files.write(filee,footer.getBytes(), StandardOpenOption.APPEND);
    }
}
