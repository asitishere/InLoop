package steps;

import driver.DriverInit;
import driver.SeleniumDriverManager;
import org.openqa.selenium.WebDriver;
import util.PropertyReader;

public class BaseSteps {
    private static SeleniumDriverManager driverManager;
    private static WebDriver driver;

    public WebDriver getDriverInstance(){
        driverManager = DriverInit.getManager();
        driver=driverManager.getDriver();
        return driver;
    }

    public void quitDriverInstance(){
        driverManager.quitDriver();
    }

    public void initTheApp(){
        driver.get(new PropertyReader().getPageURL());
    }



}
