package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactory extends BasePage {

    @FindBy(id="button")
    WebElement button;

    public PageFactory(){
        super(driver);
        driver.get("www.google.com");
    }
    
}
