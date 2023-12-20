package steps;

import org.junit.Assert;

import cucumber.api.java.en.*;
import pages.Exercise1Page;

public class Exercise1Steps {


    Exercise1Page amazonPage = new Exercise1Page();

    @Given("^I navigate to the Amazon Website$")
    public void navigateToAmazonPage(){
        amazonPage.navigateToAmazon();
    }
    @And("^I search for (.+) in the products search bar$")
    public void searchForItem(String item){
        amazonPage.enterItemSearch(item);
        amazonPage.clickSearchButton();
    }
    @And("^I navigate to the (\\d+) page$")
    public void enterPageToNavigateTo(Integer numberPage){
        amazonPage.goToItemPage(numberPage);
    }
    @And("^I select the (\\d+) item$")
    public void selectNumberedItem(Integer numberItem){
        amazonPage.clickOnCertainItem(numberItem);
    }
    @Then("^I can assert if the item is available for purchase$")
    public void checkItemIsPurchable(){
        Assert.assertTrue(amazonPage.isItemPurchable());
        Assert.assertTrue(amazonPage.hasItemBeenAddedToCart());
    }


    
}