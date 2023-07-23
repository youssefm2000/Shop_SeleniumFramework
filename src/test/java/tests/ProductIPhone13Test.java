package tests;

import data.DataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LoginPage.LoginPage;
import pages.ProductIPhone13.ProductIPhone13;


import java.io.IOException;


public class ProductIPhone13Test extends TestBase {
    public ProductIPhone13 productIPhone13;
    public LoginPage loginPage;
    public HomePage homePage;


    @Test(description = "View Information Of IPhone Product")
    public void ViewIPhoneInfotmation() throws InterruptedException, IOException, ParseException {
        DataReader dataReader = new DataReader();
        dataReader.Reader();

        loginPage = new LoginPage(driver);
        loginPage.Logining(dataReader.eemail,dataReader.ppassword);
        Thread.sleep(1000);

        homePage = new HomePage(driver);
        homePage.SearchForProductIPhone();
        Thread.sleep(2000);

        productIPhone13 = new ProductIPhone13(driver);
        productIPhone13.ViewIPhoneInformation();
    }

}
