package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class ListPage extends BasePage {
    
    private String searchField = "//input[@id = 'searchBox']";
    private String searchResults = "rt-td";

    public ListPage () {
        super(driver);
    }
    
    public void navigateToListPage(){
        navigateTo("https://demoqa.com/books");
    }

    public void enterSearchCriteria(String searchText) {
        try{
            write(searchField, searchText);    
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
