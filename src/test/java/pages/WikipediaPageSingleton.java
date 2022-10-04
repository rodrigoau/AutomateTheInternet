package pages;

import base.SetupFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static base.DriverFactory.getDriver;

public class WikipediaPageSingleton extends SetupFactory {
    WebDriver driver = getDriver();

    private WikipediaPageSingleton(){}

    public static WikipediaPageSingleton getWikipediaPage(){
        return new WikipediaPageSingleton();
    }
    private final By searchBarInput = By.xpath("//*[@id='searchInput']");
    private final By searchButton = By.xpath("//*[@id='searchButton']");
    private final By titleText = By.className("mw-page-title-main");

    public WikipediaPageSingleton searchFor(String context){
        WebElement searchBarElement = driver.findElement(searchBarInput);
        searchBarElement.click();
        searchBarElement.clear();
        searchBarElement.sendKeys(context);
        return this;
    }

    public WikipediaPageSingleton submit(){
        WebElement searchButtonElement = driver.findElement(searchButton);
        searchButtonElement.click();
        return this;
    }

    public WikipediaPageSingleton validateTitle(String context){
        WebElement titleTextElement = driver.findElement(titleText);
        String titleText = titleTextElement.getText();
        if(titleText.contains(context)){
            System.out.println("The page is correct");
        } else {
            System.out.println("The page is not correct");
        }
        return this;
    }

    public WikipediaPageSingleton takeScreenShot() throws IOException {
        File evidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(evidence, new File("src/test/screenshots/"+getClass().getSimpleName()+".png"));
        return this;
    }

}
