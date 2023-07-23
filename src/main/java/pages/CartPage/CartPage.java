package pages.CartPage;


import pages.PaymentPage.PaymentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage {

    public WebDriver driver;

    // locate elements
   private final By MyCartext = By.xpath("//h1[contains(text(),'My Cart')]");
   private final By  zaratitle = By.xpath("//h3[contains(text(),'zara coat 3')]");
    private final By  zaraprice = By.xpath("(//p)[5]");
    private final By  iphonetitle = By.xpath("//h3[contains(text(),'iphone 13 pro')]");
    private final By  iphoneprice = By.xpath("(//p)[9]");
    private final By total = By.xpath("(//span)[4]");
    private final By checkout =By.xpath("(//button)[10]");


    //create constructor to initiliaze elements
    public CartPage(WebDriver driver){
        this.driver=driver;
    }

    // method for Check My Cart Page to check 2 Products that I added them and check Total price
   public PaymentPage CheckMyCart() throws InterruptedException {
       WebElement ctext= driver.findElement(MyCartext);
       Assert.assertEquals(ctext.getText(),"My Cart");
       WebElement ztitle =driver.findElement(zaratitle);
       Assert.assertEquals(ztitle.getText(),"ZARA COAT 3");
       WebElement zprice =driver.findElement(zaraprice);
       Assert.assertEquals(zprice.getText(),"$ 31500");
       WebElement iphtitle=  driver.findElement(iphonetitle);
       Assert.assertEquals(iphtitle.getText(),"IPHONE 13 PRO");
       WebElement iphprice =driver.findElement(iphoneprice);
       Assert.assertEquals(iphprice.getText(),"$ 231500");
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
       Thread.sleep(2000);
       WebElement tot=driver.findElement(total);
       Assert.assertEquals(tot.getText(),"$263000");
       driver.findElement(checkout).click();
       Thread.sleep(1000);
       return new PaymentPage(driver);

   }

}
