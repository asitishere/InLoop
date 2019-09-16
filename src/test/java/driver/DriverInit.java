package driver;

import util.PropertyReader;

public class DriverInit {

    public static SeleniumDriverManager getManager() {

         SeleniumDriverManager driverManager =null;

        String type= new PropertyReader().getBrowserName().toUpperCase().trim();
        if ("CHROME".equals(type)) {
            driverManager = new ChromeDriverManager();
        } if("FIREFOX".equals(type)) {
            driverManager = new FirefoxDriverManager();
        }
        return driverManager;
    }

}
