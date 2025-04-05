package web.pages;

import web.base.SetupFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static web.base.DriverFactory.getDriver;

public class WikipediaPagePOM extends SetupFactory {
    WebDriver driver = getDriver();

    public WikipediaPagePOM(WebDriver driver){
        this.driver  = driver;
    }
    private final By searchBarInput = By.xpath("//*[@id='searchInput']");
    private final By searchButton = By.xpath("//*[@id='searchButton']");
    private final By titleText = By.className("mw-page-title-main");

    public void searchFor(String context){
        WebElement searchBarElement = driver.findElement(searchBarInput);
        searchBarElement.click();
        searchBarElement.clear();
        searchBarElement.sendKeys(context);
    }

    public boolean searchForAssert(String context){
        boolean itPassed;
        try{
            WebElement searchBarElement = driver.findElement(searchBarInput);
            searchBarElement.click();
            searchBarElement.clear();
            searchBarElement.sendKeys(context);
            itPassed = true;
        } catch(Exception e){
            System.out.println(e);
            itPassed = false;
        }
        return itPassed;
    }

    public void submit(){
        WebElement searchButtonElement = driver.findElement(searchButton);
        searchButtonElement.click();
    }
}
