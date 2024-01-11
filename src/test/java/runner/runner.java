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

    private static String DESIRED_BROWSER = "Chrome";
    private static String DESIRED_TIMEOUT = "3";

    @BeforeClass
    public static void initializeBrowser(){
        System.setProperty("browser", DESIRED_BROWSER);
        System.setProperty("timeout", DESIRED_TIMEOUT);
    }

    @AfterClass
    public static void cleanDriver(){
        BasePage.closeBrowser();
    }
}