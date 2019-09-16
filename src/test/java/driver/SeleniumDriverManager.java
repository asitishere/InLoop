package driver;

import org.openqa.selenium.WebDriver;

public abstract class SeleniumDriverManager {

    protected static WebDriver driver;
    protected abstract void createDriver();

    public WebDriver getDriver() {
        if (null == driver) {
            createDriver();
        }
        return driver;
    }

    protected void setDriver(WebDriver driver){
        this.driver=driver;
    }

    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }

}