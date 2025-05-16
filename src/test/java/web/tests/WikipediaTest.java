package web.tests;

import web.base.SetupFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.pages.WikipediaPageSingleton;
import web.pages.WikipediaPagePOM;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static web.base.DriverFactory.getDriver;
import static web.pages.WikipediaPageSingleton.getWikipediaPage;

public class
WikipediaTest extends SetupFactory {

    String propFile = "src/test/resources/data.properties";
    Properties prop = new Properties();
    String searchContext;

    WikipediaPageSingleton wikiPage = getWikipediaPage();

    @BeforeClass
    public void initializeTest() throws IOException {
        prop.load(new FileInputStream(new File(propFile)));
        this.searchContext = prop.getProperty("data.search");
    }

    @Test(enabled = true)
    public void searchForSomethingTest() throws IOException {
        wikiPage.searchFor(searchContext).submit().validateTitle(searchContext).takeScreenShot();
    }

    @Test(enabled = false)
    public void searchForSomethingAssertTest(){
        WikipediaPagePOM wkf = new WikipediaPagePOM(getDriver());
        Assert.assertTrue(wkf.searchForAssert(searchContext), "Failed trying to search.");
    }
}
