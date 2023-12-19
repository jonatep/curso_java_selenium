package steps;

import cucumber.api.java.en.*;
import pages.GridPage;

public class GridSteps {


    GridPage gridPage = new GridPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage(){
        gridPage.navigateToGridPage();
    }
    @Then("^I can return the value I wanted$")
    public void returnValue(){
        String value = gridPage.getValueFromGrid(3, 2);
        System.out.println(value);
    }
}