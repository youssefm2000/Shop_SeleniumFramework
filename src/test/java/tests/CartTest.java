package tests;

import data.DataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.CartPage.CartPage;
import pages.HomePage.HomePage;
import pages.LoginPage.LoginPage;
import pages.ProductIPhone13.ProductIPhone13;
import pages.ProductZara.ProductZara;


import java.io.IOException;

public class CartTest extends TestBase{
    public CartPage cartPage;
    public LoginPage loginPage;
    public HomePage homePage;
    public ProductZara productZara;
    public ProductIPhone13 productIPhone13;


    @Test(description = "Check My Cart Page ")
    public void CheckCartPage() throws InterruptedException, IOException, ParseException {
        DataReader dataReader = new DataReader();
        dataReader.Reader();


        loginPage = new LoginPage(driver);
        loginPage.Logining(dataReader.eemail,dataReader.ppassword);
        Thread.sleep(2000);

        homePage = new HomePage(driver);
        homePage.SearchForProductZara("za");
        Thread.sleep(2000);

        productZara = new ProductZara(driver);
        productZara.ViewZaraInformation();

        Thread.sleep(2000);
        homePage = new HomePage(driver);
        homePage.SearchForProductIPhone();

        productIPhone13 = new ProductIPhone13(driver);
        productIPhone13.ViewIPhoneInformation();

        homePage.goToCartPage();

        cartPage = new CartPage(driver);
        cartPage.CheckMyCart();
    }
}
