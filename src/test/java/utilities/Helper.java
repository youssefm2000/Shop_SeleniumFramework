package Utilities;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

    //create method to take screenshot while test case fail
     public static  void capturescreenshot(WebDriver driver, String screenshotname) {

        Path des =Paths.get("./Screenshots",screenshotname+".png");
        try {
            Files.createDirectories(des.getParent());
            FileOutputStream out = new FileOutputStream(des.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
            System.out.println("Exception while take screenshot"+e.getMessage());
        }

    }
}