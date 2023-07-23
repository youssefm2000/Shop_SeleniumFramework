package pages.HomePage;


import com.github.dockerjava.api.model.LogConfig;
import pages.CartPage.CartPage;
import pages.ProductIPhone13.ProductIPhone13;
import pages.ProductZara.ProductZara;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage {
    public WebDriver driver;

    // locate elements
    private final By searchfield = By.xpath("(//input[@name='search'])[2]");
    private final By zaraelementtext = By.xpath("//b[contains(text(),'zara coat 3')]");
    private final By viewzarabutton = By.xpath("(//button)[6]");
    private final By electronicbox = By.xpath("//body/app-root[1]/app-dashboard[1]/section[1]/form[1]/div[3]/div[3]/input[1]");
    private final By IPhoneelementtext = By.xpath("//b[contains(text(),'iphone 13 pro')]");
    private final By viewIPhonebutton = By.xpath("(//button[@tabindex='0'])[4]");
    private final By cartnaviagte = By.xpath("(//button)[3]");
    private final By logoutlink = By.xpath("(//button[@class='btn btn-custom'])[4]");

    //create constructor to initiliaze elements
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    // method for Searching For Product Zara and check title and click on view button to see information about it
    public ProductZara SearchForProductZara(String productname) throws InterruptedException {
        WebElement searchzara = driver.findElement(searchfield);
        searchzara.sendKeys(productname);
        Thread.sleep(1000);
        searchzara.click();
        Thread.sleep(1000);
        WebElement ztxt=  driver.findElement(zaraelementtext);
        Assert.assertEquals(ztxt.getText(),"ZARA COAT 3");
        driver.findElement(viewzarabutton).click();
        Thread.sleep(1000);
        return new ProductZara(driver);
    }

    // method for Searching For Product IPhone 13 and check title and click on view button to see information about it
    public ProductIPhone13 SearchForProductIPhone() throws InterruptedException {
        driver.findElement(electronicbox).click();
        Thread.sleep(1000);
        WebElement iphonetxt =  driver.findElement(IPhoneelementtext);
        Assert.assertEquals(iphonetxt.getText(),"IPHONE 13 PRO");
        driver.findElement(viewIPhonebutton).click();
        Thread.sleep(1000);
        return new ProductIPhone13(driver);
    }

    // method to click on cart Button to naviage to Cart Page
    public CartPage goToCartPage() throws InterruptedException {
        driver.findElement(cartnaviagte).click();
        Thread.sleep(1000);
        return new CartPage(driver);
    }

    // method for Log out
    public void LogOutclick(){
        driver.findElement(logoutlink).click();
    }


}
