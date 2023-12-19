package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import cucumber.api.Scenario;

import cucumber.api.java.After;
import pages.BasePage;

public class Hooks extends BasePage {

    public Hooks() {
        super(driver);
    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){
            scenario.write("Ha habido un fallo");
            final byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
    
   

}
