package tests;

import data.DataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LoginPage.LoginPage;

import java.io.IOException;

public class HomeForIPoneTest extends TestBase{
    public HomePage homePage;
    public LoginPage loginPage;


    @Test(description = "Select IPhone 13 Pro Product")
    public void SelectIPhone13() throws InterruptedException, IOException, ParseException {
        DataReader dataReader = new DataReader();
        dataReader.Reader();

        loginPage = new LoginPage(driver);
        loginPage.Logining(dataReader.eemail,dataReader.ppassword);
        Thread.sleep(1000);

        homePage = new HomePage(driver);
        homePage.SearchForProductIPhone();
    }
}
