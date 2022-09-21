package pages;

import base.SetupFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static base.DriverFactory.getDriver;

public class WikipediaPage extends SetupFactory {
    WebDriver driver = getDriver();

    private WikipediaPage(){}

    private final By searchBarInput = By.xpath("//*[@id='searchInput']");
    private final By searchButton = By.xpath("//*[@id='searchButton']");
    private final By titleText = By.className("mw-page-title-main");
    public static WikipediaPage getWikipediaPage(){
        return new WikipediaPage();
    }

    public WikipediaPage searchFor(String context){
        WebElement searchBarElement = driver.findElement(searchBarInput);
        searchBarElement.click();
        searchBarElement.clear();
        searchBarElement.sendKeys(context);
        return this;
    }

    public WikipediaPage submit(){
        WebElement searchButtonElement = driver.findElement(searchButton);
        searchButtonElement.click();
        return this;
    }

    public WikipediaPage validateTitle(String context){
        WebElement titleTextElement = driver.findElement(titleText);
        String titleText = titleTextElement.getText();
        if(titleText.contains(context)){
            System.out.println("The page is correct");
        } else {
            System.out.println("The page is not correct");
        }
        return this;
    }

    public WikipediaPage takeScreenShot() throws IOException {
        File evidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(evidence, new File("src/test/screenshots/"+getClass().getSimpleName()+".png"));
        return this;
    }

}
