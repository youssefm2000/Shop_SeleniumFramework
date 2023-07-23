package pages.PaymentPage;


import pages.SubmitOrderPage.SubmitOrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PaymentPage {
    public WebDriver driver;
    private final By paymenttitle = By.xpath("//div[contains(text(),'Payment Method')]");
    private final By shippinginf = By.xpath("(//div[@class='payment__title'])[3]");
    private final By selectcountry =By.xpath("(//input)[7]");
    private final By selectegypt = By.xpath("(//span)[4]");
    private final By placeholder = By.xpath("(//a)[2]");


    //create constructor to initiliaze elements
    public PaymentPage(WebDriver driver){

        this.driver=driver;
    }

    // method for check Payment way for products
    public SubmitOrderPage PaymentOfProduct(String countryname) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
        Thread.sleep(2000);
        WebElement ptitle = driver.findElement(paymenttitle);
        Assert.assertEquals(ptitle.getText(),"Payment Method");
        WebElement shipinf =  driver.findElement(shippinginf);
        Assert.assertEquals(shipinf.getText(),"Shipping Information");
        driver.findElement(selectcountry).sendKeys(countryname);
        driver.findElement(selectegypt).click();
        driver.findElement(placeholder).click();
        Thread.sleep(2000);
        return new SubmitOrderPage(driver);
    }
}
