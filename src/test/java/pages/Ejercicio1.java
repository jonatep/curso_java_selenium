package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class Ejercicio1 extends BasePage {
    
    private String searchField = "//input[@id='twotabsearchtextbox']";
    private String searchResults = "rt-td";

    public Ejercicio1 () {
        super(driver);
    }
    
    public void navigateToAmazon(){
        navigateTo("https://www.amazon.com");
    }

    public void enterSearchCriteria(String item) {
        try{
            write(searchField, item);    
        }catch(NoSuchElementException e){
            System.out.println("The WebElement Search Field couldn't be found");
            e.printStackTrace();
        }
    }

    public List<String> getAllSearchResults(){
        List<WebElement> listWebElements = bringAllElements(searchResults);
        List<String> stringsFromList = new ArrayList<String>();
        for(WebElement e: listWebElements){
            stringsFromList.add(e.getText());
        }
        return stringsFromList;
    }

}
