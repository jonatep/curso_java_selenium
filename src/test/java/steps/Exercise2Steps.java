package steps;

import org.junit.Assert;

import cucumber.api.java.en.*;
import pages.Exercise2Page;

public class Exercise2Steps {


    Exercise2Page tradeMePage = new Exercise2Page();

    @Given("^I navigate to the TradeMe website$")
    public void navigateToTradeMePage(){
        tradeMePage.navigateToTradeMe();
    }
    @When("^I select the car (.+) in the make dropdown$")
    public void selectCarBrand(String car){

    }

    @Then("^I can assert that the number of cars in the dropdown is X$")
    public void assertNumCarsDropdown(){

    }
    @Then("^I can assert that the number of cars from that brand is (\\d+)$")
    public void assertNumberBrands(Integer amount){

    }

    @Then("^I can assert that the number of cars in the TradeMe API is X$")
    public void assertNumCarsAPI(){

    }
    
}