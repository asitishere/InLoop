package driver;

import util.OsUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class FirefoxDriverManager extends SeleniumDriverManager {
    public void createDriver() {

        if (OsUtils.getOperatingSystemName().contains("Mac")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//browserExecutors/firefox/geckodriver");
            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability("marionette", true);
            setDriver(new FirefoxDriver(capabilities));
        }
    }
}