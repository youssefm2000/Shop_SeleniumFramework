package pages.ProductZara;


import pages.HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class ProductZara {

    public WebDriver driver;

    // locate elements
    private final By titlezara = By.xpath("//h2[contains(text(),'zara coat 3')]");
    private final By salaryzara = By.xpath("//h3[contains(text(),'$ 31500')]");
    private final By AddToCartzarabtn = By.cssSelector("button.btn.btn-primary");
    private final By Continuezarabtn = By.cssSelector("a.continue");



    //create constructor to initiliaze elements
    public ProductZara(WebDriver driver){
        this.driver=driver;
    }


    // method for View Information Of Zara Product To check It
    public HomePage ViewZaraInformation() throws InterruptedException {
        WebElement ztxt = driver.findElement(titlezara);
        Assert.assertEquals(ztxt.getText(),"ZARA COAT 3");
        WebElement pricez = driver.findElement(salaryzara);
        Assert.assertEquals(pricez.getText(),"$ 31500");
        driver.findElement(AddToCartzarabtn).click();
        driver.findElement(Continuezarabtn).click();
        Thread.sleep(1000);
        return new HomePage(driver);
    }


}
