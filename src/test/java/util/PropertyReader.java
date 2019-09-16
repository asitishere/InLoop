package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    String browserPropertyPath = System.getProperty("user.dir")+ "/browser_config.properties";
    Properties browserProps = new Properties();


    public PropertyReader(){
        try {
            browserProps.load(new FileInputStream(browserPropertyPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getBrowserName() {
        return browserProps.getProperty("browser.name");
    }

    public String getPageURL(){
        return browserProps.getProperty("browser.url");
    }

}
