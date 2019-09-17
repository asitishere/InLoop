package steps;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public class StartingSteps extends BaseSteps {

    Scenario scenario;
    @Before
    public void setUp(Scenario scenario){
        this.scenario=scenario;
        getDriverInstance();
        initTheApp();
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot)getDriverInstance()).getScreenshotAs(OutputType.BYTES), "image/png");
        }
        quitDriverInstance();
    }

}
