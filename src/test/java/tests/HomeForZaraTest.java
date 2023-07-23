package tests;

import data.DataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.HomePage.HomePage;
import pages.LoginPage.LoginPage;

import java.io.IOException;

public class HomeForZaraTest extends TestBase{
    public HomePage homePage;
    public LoginPage loginPage;



    @Test(description = "Select Zara Product")
    public void SearchForZaraElemnet() throws InterruptedException, IOException, ParseException {
        DataReader dataReader = new DataReader();
        dataReader.Reader();

        loginPage = new LoginPage(driver);
        loginPage.Logining(dataReader.eemail,dataReader.ppassword);

        homePage = new HomePage(driver);
        homePage.SearchForProductZara("za");
    }
}
