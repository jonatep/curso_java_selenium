package steps;

import java.util.List;

import org.junit.Assert;

import cucumber.api.java.en.*;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pages.Exercise2Page;
import static io.restassured.RestAssured.*;

public class Exercise2Steps {

    private ValidatableResponse json;
    private static RequestSpecification request;
    private Response response;


    Exercise2Page tradeMePage = new Exercise2Page();

    @Given("^I navigate to the TradeMe website$")
    public void navigateToTradeMePage(){
        tradeMePage.navigateToTradeMe();
    }
    @When("^I select the car (.+) in the make dropdown$")
    public void selectCarBrand(String car){
        tradeMePage.selectCarBrand(car);
    }

    @Then("^I can assert that the number of cars in the dropdown is (\\d+)$")
    public void assertNumCarsDropdown(Integer numberDropdown) throws InterruptedException{
        Assert.assertEquals(numberDropdown.intValue(), tradeMePage.getNumCarsDropdown().intValue());
    }
    @Then("^I can assert that the number of cars from that brand is (\\d+)$")
    public void assertNumberBrands(Integer amount){
        Assert.assertEquals(amount, tradeMePage.getNumCarResults());
    }
    @Given("^I send a GET request to the API adress$")
    public void sendAPIGETRequest() {
        request = given()
        .log().all()
        .param("", "");
        response = request
        .when()
        .get("https://api.trademe.co.nz/v1/Categories/UsedCars.json");
    }
    @Then("^I can assert that the number of cars in the TradeMe API is (\\d+)$")
    public void assertNumCarsAPI(Integer numberAPI){
        json = response.then().statusCode(200);
        List<String> jsonResponse = response.jsonPath().getList("Subcategories.Name");
        Assert.assertEquals(numberAPI.intValue(), jsonResponse.size());
    }
    
}