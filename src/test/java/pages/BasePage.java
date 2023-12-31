package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static{
        initializeDriver(System.getProperty("browser"));
        closeBrowser();
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Long.parseLong(System.getProperty("timeout")));
    }

    public static void initializeDriver(String browser) {

        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            
            case "Safari":
                SafariOptions safariOptions = new SafariOptions();
                driver = new SafariDriver(safariOptions);
                break;

            case "Edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                driver = new EdgeDriver(edgeOptions);
                break;
        
            default:
                System.out.println("El navegador seleccionado no es compatible");
                break;
        }


        wait = new WebDriverWait(driver, Long.parseLong(System.getProperty("timeout")));
        action = new Actions(driver);
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }


    private WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        find(locator).click();
    }

    public void write(String locator, String textToWrite){
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropDown = new Select(find(locator));
        dropDown.selectByValue(valueToSelect);
    }


    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropDown = new Select(find(locator));
        dropDown.selectByIndex(valueToSelect);
    }

    public void hoverOverElement(String locator){
        action.moveToElement(find(locator));
    }

    public void doubleClick(String locator){
        action.doubleClick(find(locator));
    }

    public void rightClick(String locator){
        action.contextClick(find(locator));
    }

    public String getValueFromTable(String locator, int row, int column){
        String requestedCell = locator + "//table/tbody/tr[" + row + "]/td[" + column + "]";
        return find(requestedCell).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator + "//table/tbody/tr[" + row + "]/td[" + column + "]";
        find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToiFrame(String iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        try{
            driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }
        
    }

    public String textFromElement(String locator){
        return find(locator).getText();
    }

    public boolean elementIsDisplayed(String locator){
        return find(locator).isDisplayed(); 
    }

    public boolean elementIsSelected(String locator){
        return find(locator).isSelected();
    }

    public List<WebElement> bringAllElements(String locator){
        return driver.findElements(By.className(locator));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void goToNumberedPage(Integer page){
        String pageUrl = "&page=" + page;
        Pattern r = Pattern.compile("&page=(\\d*)");
        Matcher m = r.matcher(getCurrentUrl());

        if (m.find()){
            driver.get(getCurrentUrl().replaceFirst(m.group(1), page.toString()));
        }
        else{
            driver.get(getCurrentUrl() + pageUrl);
        }
    }

    public Integer getNumElements(String locator){
        return driver.findElements(By.xpath(locator)).size();
    }

    public String getTextFromLocator(String locator){
        return find(locator).getText();
    }
}
