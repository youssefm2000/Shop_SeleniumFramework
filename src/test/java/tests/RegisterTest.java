package tests;

import data.DataReader;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import pages.RegisterPage.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase {
    public RegisterPage registerPage;


   @Test(description = "User Can Register To Craete account")
    public void UserRegister() throws InterruptedException, IOException, ParseException {
      DataReader dataReader = new DataReader();
       dataReader.Reader();
        registerPage = new RegisterPage(driver);
        registerPage.naviageteToRegsiterlink();
        registerPage.Registeration(dataReader.ffirstname,dataReader.llastname,dataReader.eemail, dataReader.pphonenum,dataReader.ppassword,dataReader.cconFirmapass);
    }
}
