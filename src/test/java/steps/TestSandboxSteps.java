package steps;

import cucumber.api.java.en.*;
import pages.TestSandboxPage;

public class TestSandboxSteps {


    TestSandboxPage sandBox = new TestSandboxPage();

    @Given("^I navigate to the sandbox page$")
    public void navigateToGoogle(){
        sandBox.navigateToTestPage();
    }
    @And("^select a value from the dropdown$")
    public void clickSearchButton(){
        sandBox.selectGender("female");
    }
}