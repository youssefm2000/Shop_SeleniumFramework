package pages.SubmitOrderPage;


import pages.LoginPage.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SubmitOrderPage {

    public WebDriver driver;

    //locate elements
     private final By Thankstext = By.cssSelector("h1.hero-primary");
    private final By download = By.xpath("(//button)[5]");
    private final By signout =By.xpath("(//button)[4]");


    //create constructor to initiliaze elements
    public SubmitOrderPage(WebDriver driver){
        this.driver=driver;
    }

    // method for check 2 products before submit order to buy them
    public LoginPage CheckOrderToSubmit() throws InterruptedException {
        WebElement context = driver.findElement(Thankstext);
        Assert.assertEquals(context.getText(),"THANKYOU FOR THE ORDER.");
        WebElement conele= driver.findElement(download);
        Assert.assertEquals(conele.getText(),"Click To Download Order Details in CSV");
        conele.click();
        Thread.sleep(1500);
        driver.findElement(signout).click();
        return new LoginPage(driver);
    }
}
