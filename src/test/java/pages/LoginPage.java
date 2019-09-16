package pages;

import com.paulhammant.ngwebdriver.ByAngular;
import com.paulhammant.ngwebdriver.ByAngularBinding;
import com.paulhammant.ngwebdriver.ByAngularModel;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    private WebDriver driver;
    private  NgWebDriver ngDriver;

    public LoginPage(WebDriver driver) {
        super((driver));
        this.driver=driver;
        this.ngDriver=new NgWebDriver((JavascriptExecutor) driver);
    }

    @ByAngularModel.FindBy(rootSelector = "loginForm", model = "user.name")
    private WebElement userNameTextBox;

    @ByAngularModel.FindBy(rootSelector = "loginForm", model = "user.password")
    private WebElement passwordTextBox;

    private By loggedInGreetings=By.id("greetings");


    public void setUserId(String userID){
        ngDriver.waitForAngularRequestsToFinish();
        userNameTextBox.sendKeys(userID);
        // driver.findElement(ByAngular.model("user.name")).sendKeys("Luke");
    }

    public void setPassword(String password) {
        ngDriver.waitForAngularRequestsToFinish();
        passwordTextBox.sendKeys(password);
    }

    public void logCustomerInDetails(String userName, String password){
        setUserId(userName);
        setPassword(password);
    }

    public void clickOnLogIn() {
        driver.findElement(ByAngular.buttonText("Login")).click();
    }

    public String getGreetingsMessage(){
        return driver.findElement(By.id("greetings")).getText();
    }



}
