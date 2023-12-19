package pages;

public class GooglePage extends BasePage {
    
    public GooglePage () {
        super(driver);
    }

    private String cookiesButton = "//button[@id='W0wltc']";
    private String searchButton = "//div[contains(@class, 'lJ9FBc')]//input[contains(@class, 'gNO89b')]";
    private String searchTextArea = "//textarea[contains(@class, 'gLFyf')]";
    private String firstResult = "";
    
    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
        clickElement(cookiesButton);
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextArea, criteria);
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }

}
