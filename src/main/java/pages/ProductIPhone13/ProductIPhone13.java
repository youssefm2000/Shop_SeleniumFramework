package pages.ProductIPhone13;


import pages.HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductIPhone13 {

    public WebDriver driver;

    // locate elements
    private final By titleiphone = By.xpath("//h2[contains(text(),'iphone 13 pro')]");
    private final By salaryiphone = By.xpath("//h3[contains(text(),'$ 231500')]");
    private final By AddToCartiphonebtn = By.xpath("//button[contains(text(),'Add to Cart')]");
    private final By  Continueiphonebtn = By.cssSelector("a.continue");



    //create constructor to initiliaze elements
    public ProductIPhone13(WebDriver driver){
        this.driver=driver;
    }



     // method for View Information Of Iphone 13 Pro Product To check It
    public HomePage ViewIPhoneInformation() throws InterruptedException {
        WebElement iphtext =driver.findElement(titleiphone);
        Assert.assertEquals(iphtext.getText(),"IPHONE 13 PRO");
        WebElement ipsalary =driver.findElement(salaryiphone);
        Assert.assertEquals(ipsalary.getText(),"$ 231500");
        driver.findElement(AddToCartiphonebtn).click();
        driver.findElement(Continueiphonebtn).click();
        Thread.sleep(1000);
        return new HomePage(driver);
    }
}
