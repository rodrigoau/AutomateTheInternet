package tests;

import base.SetupFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.WikipediaPageSingleton;
import pages.WikipediaPagePOM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static base.DriverFactory.getDriver;
import static pages.WikipediaPageSingleton.getWikipediaPage;

public class WikipediaTest extends SetupFactory {

    WebDriver driver = getDriver();

    String propFile = "src/test/resources/data.properties";
    Properties prop = new Properties();
    String searchContext;

    WikipediaPageSingleton wikiPage = getWikipediaPage();

    @BeforeClass
    public void initializeTest() throws IOException {
        prop.load(new FileInputStream(new File(propFile)));
        this.searchContext = prop.getProperty("data.search");
    }

    @Test(enabled = false)
    public void searchForSomethingTest() throws IOException {
        wikiPage.searchFor(searchContext).submit().validateTitle(searchContext).takeScreenShot();
    }

    @Test
    public void searchForSomethingAssertTest(){
        WikipediaPagePOM wkf = new WikipediaPagePOM(getDriver());
        Assert.assertTrue(wkf.searchForAssert(searchContext), "Failed trying to search.");
    }
}
