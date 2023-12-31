package runner;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import pages.BasePage;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "steps",
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "json:target/cucumber-reports.json"},
    tags = "@Test"
)

public class runner{

    @BeforeClass
    public static void initializeBrowser(){
        System.setProperty("browser", "Chrome");
        System.setProperty("timeout", "3");
    }

    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}