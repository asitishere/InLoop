package driver;

import util.OsUtils;
import org.openqa.selenium.chrome.ChromeDriver;
public class ChromeDriverManager extends SeleniumDriverManager {

    @Override
    public void createDriver() {
        if (OsUtils.getOperatingSystemName().contains("Mac")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/browserExecutors/chrome/chromedriver");
            setDriver(new ChromeDriver());
        }

        //TODO: Need to set for Windows
    }


}
