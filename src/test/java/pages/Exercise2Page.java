package pages;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.json.JSONObject;
import java.net.*;

import org.apache.commons.io.IOUtils;
import java.nio.charset.*;
import java.io.IOException;

public class Exercise2Page extends BasePage {
    
    private String makeDropdownItems = "(//select[@name='selectedMake'])";
    private String searchButton = "//button[contains(@class, 'search-bar')][@type='submit']";
    private String carResultsLocator = "//tm-search-header-result-count//h3";

    public Exercise2Page () {
        super(driver);
    }
    
    public void navigateToTradeMe(){
        navigateTo("https://www.trademe.co.nz/a/motors");
    }

    public Integer getNumCarsDropdown() throws InterruptedException{
        Thread.sleep(600);
        return getNumElements(makeDropdownItems + "//option");
    }

    public void selectCarBrand(String car){
        clickElement(makeDropdownItems);
        clickElement(makeDropdownItems + "//option[@value='" + car + "']");
        clickElement(searchButton);
    }
    
    public Integer getNumCarResults(){
        Pattern r = Pattern.compile("Showing (\\d*,?\\d*) results");
        Matcher m = r.matcher(getTextFromLocator(carResultsLocator));
        if (m.find()){
            return Integer.valueOf(m.group(1).replace(",", ""));
        }
        else{
            return 0;
        }
    }

    private URL getURLForAPI(String urlString) throws MalformedURLException{
        URL urlAPI = new URL(urlString);
        return urlAPI;
    }

    private JSONObject getJson(URL url) throws IOException {
        String json = IOUtils.toString(url, Charset.forName("UTF-8"));
        return new JSONObject(json);
    }

    public Integer getNumCarAPI() throws IOException{
        return getJson(getURLForAPI("https://api.trademe.co.nz/v1/Categories/UsedCars.json")).length();
    }



}
