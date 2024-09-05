package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.WikipediaPageSingleton;

import static org.testng.Assert.assertTrue;
import static pages.WikipediaPageSingleton.getWikipediaPage;

public class CucumberTest {
    WebDriver driver;
    WikipediaPageSingleton wikiPage = getWikipediaPage();

    @Given("the user is on the Wikipedia homepage")
    public void userIsInHomePage(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/idsay/Downloads/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://es.wikipedia.org/");
    }

    @When("the user searches for Microsoft")
    public void userSearchForSomething(){
        wikiPage.searchFor("Microsoft").submit();
    }

    @Then("the user should see the search results page")
    public void validatePage(){
        assertTrue(driver.getTitle().contains("Microsoft"));
    }



}
