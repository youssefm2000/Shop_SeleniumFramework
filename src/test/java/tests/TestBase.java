package tests;

import Utilities.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase extends AbstractTestNGCucumberTests {
    public WebDriver driver;

    // To Start Driver
    @BeforeClass
    @Parameters({"browser"})
    public void setup(@Optional("chrome")  String browsername){


            if (browsername.contains("chrome")) {
                ChromeOptions options = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                if (browsername.contains("headless")){
                    options.addArguments("headless");
                }

                driver = new ChromeDriver(options);
                driver.manage().window().setSize(new Dimension(1440,900));

            }
            else if (browsername.contains("firefox")) {
               WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();

            }

            // to maximize window
            driver.manage().window().maximize();

        // to give 10 seconds before can not catch element and display NoSuchElementException
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.navigate().to("https://rahulshettyacademy.com/client");


    }

    //To close Driver
    @AfterClass
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
        }



    //take screenshot when test case fail and added to Screenshots folder
    @AfterMethod
    public void takescreenshot(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            System.out.println("Failed!");
            System.out.println("TAKING Screenshot .....");
            Helper.capturescreenshot(driver, result.getName());
        }
    }

}
