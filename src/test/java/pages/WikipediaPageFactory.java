package pages;

import base.SetupFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static base.DriverFactory.getDriver;

public class WikipediaPageFactory extends SetupFactory {

    WebDriver driver = getDriver();

    public WikipediaPageFactory(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how=How.XPATH, using="//*[@id='searchInput']")
    WebElement searchBarInput;

    @FindBy(xpath="//*[@id='searchButton']")
    WebElement searchButton;

    public void searchFor(String context){
        searchBarInput.click();
        searchBarInput.clear();
        searchBarInput.sendKeys(context);
    }

}
