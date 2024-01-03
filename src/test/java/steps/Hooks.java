package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import pages.BasePage;

public class Hooks extends BasePage {

    public Hooks() {
        super(driver);
    }

    @Before
    public void initializeDriver(Scenario scenario){
        BasePage.initializeDriver(System.getProperty("browser"));
    }

    @After
    public void tearDownAndClose(Scenario scenario) {
        BasePage.closeBrowser();
        if(scenario.isFailed()){
            scenario.write("Ha habido un fallo");
            final byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

}
