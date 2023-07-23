package tests;

import data.DataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.LoginPage.LoginPage;

import java.io.IOException;

public class LoginTest extends TestBase {
    public LoginPage loginPage;


    @Test(description = "User Can Login")
    public void UserLogin() throws InterruptedException, IOException, ParseException {
        DataReader dataReader = new DataReader();
        dataReader.Reader();

        loginPage = new LoginPage(driver);
        loginPage.Loginheader();
        loginPage.Logining(dataReader.eemail,dataReader.ppassword);
    }
}
