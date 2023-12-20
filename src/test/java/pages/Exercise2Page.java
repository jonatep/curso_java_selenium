package pages;

import org.openqa.selenium.NoSuchElementException;

public class Exercise2Page extends BasePage {
    
    private String makeDropdownItems = "(//select[@name='selectedMake'])//option";

    public Exercise2Page () {
        super(driver);
    }
    
    public void navigateToTradeMe(){
        navigateTo("https://www.trademe.co.nz/a/motors");
    }

}
