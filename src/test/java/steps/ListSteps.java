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
    @When("^I search on the list$")
    public void enterTextForSearch(){
        listPage.enterSearchCriteria();
    }
    @Then("^I can find the text in the list$")
    public void checkTextExists(){
        List<String> listResults = listPage.getAllSearchResults();
        boolean textIsHere = listResults.contains("Axel Rauschmayer");
        Assert.assertTrue("El texto buscado no ha sido encontrado", textIsHere);
    }


    
}