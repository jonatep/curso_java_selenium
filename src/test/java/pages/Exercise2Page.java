package pages;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import org.openqa.selenium.NoSuchElementException;

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

    public Integer getNumCarsDropdown(){
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

}
