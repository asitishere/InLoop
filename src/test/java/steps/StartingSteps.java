package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class StartingSteps extends BaseSteps {

    @Before
    public void setUp(){
        getDriverInstance();
        initTheApp();
    }

    @After
    public void tearDown(){
        quitDriverInstance();
    }

}
