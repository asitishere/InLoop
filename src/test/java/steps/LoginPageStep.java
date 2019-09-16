package steps;


import driver.DriverInit;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;

public class LoginPageStep extends BaseSteps{

LoginPage loginPage;

public LoginPageStep(){
    loginPage= new LoginPage(getDriverInstance());
}

    @Given("customer click on Login button in login form")
    public void clickOnLogIn()  {
        loginPage.clickOnLogIn();
    }

    @Given("customer enters username as {string} and password as {string}")
    public void customer_enters_username_and_password_as(String userName, String password) {
        loginPage.logCustomerInDetails(userName,password);
    }

    @Then("verify customer successfully login to the application")
    public void verifyCustomerLoggedInToApp(){
        Assert.assertTrue(loginPage.getGreetingsMessage().contains("Hello"));
    }



}
