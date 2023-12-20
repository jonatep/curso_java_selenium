package pages;

import org.openqa.selenium.NoSuchElementException;

public class Exercise1Page extends BasePage {
    
    private String searchField = "//input[@id='twotabsearchtextbox']";
    private String submitSearchButton = "//input[@id='nav-search-submit-button']";
    private String numberedItemAmazon = "(//div[@data-component-type='s-search-result'][NUMITEM]//a[contains(@class, 'a-link-normal')])[1]";
    private String cartButton = "//input[@id='add-to-cart-button']";
    private String addedToCartMessage = "//div[@id='NATC_SMART_WAGON_CONF_MSG_SUCCESS']";

    public Exercise1Page () {
        super(driver);
    }
    
    public void navigateToAmazon(){
        navigateTo("https://www.amazon.com");
    }

    public void enterItemSearch(String item) {
        try{
            write(searchField, item);    
        }catch(NoSuchElementException e){
            System.out.println("The WebElement Search Field couldn't be found");
            e.printStackTrace();
        }
    }

    public void clickSearchButton(){
        clickElement(submitSearchButton);
    }

    public void goToItemPage(Integer itemPage){
        goToNumberedPage(itemPage);
    }

    public void clickOnCertainItem(Integer positionItem){
        clickElement(numberedItemAmazon.replaceFirst("NUMITEM", positionItem.toString()));
    }

    public boolean isItemPurchable(){
        try{
            clickElement(cartButton);
        }catch(NoSuchElementException e){
            System.out.println("The item isn't abailable for purchase, as no 'Add to Cart' button exists");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean hasItemBeenAddedToCart(){
        try{
            clickElement(addedToCartMessage);
        }catch(NoSuchElementException e){
            System.out.println("The message confirmation for adding an item to the cart isn't displayed");
            e.printStackTrace();
            return false;
        }
        return true;
    }



}
