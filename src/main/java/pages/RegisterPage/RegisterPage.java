package pages.RegisterPage;


import pages.LoginPage.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPage {
    public WebDriver driver;

    // locate elements


    private final By Registerlinnk = By.xpath("//a[@class='btn1']");
    private final By fieldFirstname = By.id("firstName");
    private final By fieldLastname = By.id("lastName");
    private final By fieldEmail = By.id("userEmail");
    private final By fieldUserMobile = By.id("userMobile");
    private final By fieldoccupation = By.xpath("//select[@formcontrolname='occupation']");
    private final By malegender = By.xpath("(//input)[5]");
    private final By fieldPassword = By.id("userPassword");
    private final By fieldConfirmPassword = By.id("confirmPassword");
    private final By agebox = By.xpath("//input[@type='checkbox']");
    private final By RegisterButton = By.id("login");
    private final By successRegister = By.cssSelector("h1.headcolor");
    private final By Auth = By.xpath("//button[@routerlink='/auth']");


   //create constructor to initiliaze elements
    public RegisterPage(WebDriver driver){
        this.driver=driver;

    }

    // method for click on Register link
    public RegisterPage naviageteToRegsiterlink(){
       driver.findElement(Registerlinnk).click();
       return this;
    }



    // method for enter personal information to sign up
    public LoginPage Registeration(String fname, String lname, String email, String phonenum, String passw , String conFirmapass) throws InterruptedException {

        driver.findElement(fieldFirstname).sendKeys(fname);
        driver.findElement(fieldLastname).sendKeys(lname);
        driver.findElement(fieldEmail).sendKeys(email);
        driver.findElement(fieldUserMobile).sendKeys(phonenum);

        WebElement fieldocc = driver.findElement(fieldoccupation);
        fieldocc.click();

        Select dropdown = new Select(fieldocc);
        dropdown.selectByVisibleText("Student");

        WebElement maleg = driver.findElement(malegender);
        maleg.click();
        Assert.assertTrue(maleg.isSelected());

        driver.findElement(fieldConfirmPassword).sendKeys(passw);
        driver.findElement(fieldPassword).sendKeys(conFirmapass);

        WebElement agex =driver.findElement(agebox);
        agex.click();
        Assert.assertTrue(agex.isSelected());

        driver.findElement(RegisterButton).click();
        Thread.sleep(2000);

        WebElement succmsg =driver.findElement(successRegister);
        Assert.assertEquals(succmsg.getText(),"Account Created Successfully");
        driver.findElement(Auth).click();
        Thread.sleep(1000);
        return new LoginPage(driver);
    }
}
