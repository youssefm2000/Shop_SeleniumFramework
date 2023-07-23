package tests;

import data.DataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LoginPage.LoginPage;
import pages.ProductZara.ProductZara;


import java.io.IOException;

public class ProductZaraTest extends TestBase{
    public ProductZara productZara;
    public LoginPage loginPage;
    public HomePage homePage;



    @Test(description = "View Information Of Zara Product")
    public void ViewZaraInfotmation() throws InterruptedException, IOException, ParseException {
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
    }

}
