package pages;

public class GridPage extends BasePage {
    
    private String cell = "//div[@id='root']";
    private String mainTable = "//div[@id='root']//table";
    public GridPage () {
        super(driver);
    }

    public void navigateToGridPage(){
        navigateTo("https://1v2njkypo4.csb.app/");
    }

    public String getValueFromGrid(int row, int column){
        return getValueFromTable(cell, row, column);
    }

    public boolean cellStatus(){
        return elementIsDisplayed(mainTable);
    }
}
