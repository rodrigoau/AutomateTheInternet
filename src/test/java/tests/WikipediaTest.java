package tests;

import base.SetupFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.WikipediaPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static pages.WikipediaPage.getWikipediaPage;

public class WikipediaTest extends SetupFactory {

    String propFile = "src/test/resources/data.properties";
    Properties properties = new Properties();
    String searchContext;


    WikipediaPage wikiPage = getWikipediaPage();

    @BeforeClass
    public void initializeTest() throws IOException {
        properties.load(new FileInputStream(new File(propFile)));
        this.searchContext = properties.getProperty("data.search");
    }

    @Test
    public void searchForSomethingTest() throws IOException {
        wikiPage.searchFor(searchContext).submit().validateTitle(searchContext).takeScreenShot();
    }
}
