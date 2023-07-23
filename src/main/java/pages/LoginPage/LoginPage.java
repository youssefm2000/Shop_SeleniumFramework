package pages.LoginPage;


import pages.HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {
    public  WebDriver driver;

    // locate elements use By Way
    private final By headertext = By.cssSelector("h1.login-title");
    private final By fieldemail = By.id("userEmail");
    private final By fieldpassword = By.id("userPassword");
    private final By loginButton = By.id("login");


    //create constructor to initiliaze elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // method for check Header of Log in
    public void Loginheader(){
       WebElement htext =  driver.findElement(headertext);
        Assert.assertEquals(htext.getText(), "Log in");

    }

    // method for Log in
    public HomePage Logining(String email, String passw) throws InterruptedException {


        driver.findElement(fieldemail).sendKeys(email);
        driver.findElement(fieldpassword).sendKeys(passw);
        driver.findElement(loginButton).click();
        Thread.sleep(2000);
        return new HomePage(driver);

    }
}
