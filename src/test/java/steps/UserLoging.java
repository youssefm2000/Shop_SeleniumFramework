package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.LoginPage.LoginPage;
import tests.TestBase;

public class UserLoging extends TestBase {

     LoginPage loginPage;

    @Given("The user in home page")
    public void the_user_in_home_page() {
      loginPage = new LoginPage(driver);
      loginPage.Loginheader();
    }
    @When("i entered data user {string} ,{string}")
    public void i_entered_data_user(String email, String password) throws InterruptedException {
        loginPage.Logining(email,password);

    }
    @Then("the page of Log in  displayed successfuly")
    public void the_page_of_log_in_displayed_successfuly() {

    }

}
