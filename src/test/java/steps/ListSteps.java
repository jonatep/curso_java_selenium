package steps;

import java.util.List;

import org.junit.Assert;

import cucumber.api.java.en.*;
import pages.ListPage;

public class ListSteps {


    ListPage listPage = new ListPage();

    @Given("^I navigate to the list page$")
    public void navigateToListPage(){
        listPage.navigateToListPage();
    }
    @When("^I search (.+) in the list$")
    public void enterTextForSearch(String searchText){
        listPage.enterSearchCriteria(searchText);
    }
    @Then("^I can find (.+) in the list$")
    public void checkTextExists(String textToCheck){
        List<String> listResults = listPage.getAllSearchResults();
        boolean textIsHere = listResults.contains(textToCheck);
        Assert.assertTrue("El texto buscado no ha sido encontrado", textIsHere);
    }


    
}