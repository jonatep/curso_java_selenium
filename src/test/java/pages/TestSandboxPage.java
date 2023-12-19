package pages;

public class TestSandboxPage extends BasePage {
    
    public TestSandboxPage () {
        super(driver);
    }

    private String genderDropdown = "//select[@id='gender']";

    public void navigateToTestPage(){
        navigateTo("https://automationintesting.com/selenium/testpage/");
    }

    public void selectGender(String gender){
        selectFromDropdownByValue(genderDropdown, gender);
    }
}
