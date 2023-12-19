package steps;

import org.junit.Assert;

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
        Assert.assertEquals("r: 2, c: 1", value);
    }
    @Then("^I can validate the table is displayed$")
    public void theTableExists(){
        Assert.assertTrue("El elemento no está siendo mostrado", gridPage.cellStatus());
    }


    
}