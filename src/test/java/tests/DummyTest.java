package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static base.DriverFactory.getDriver;

public class DummyTest {

    WebDriver driver = getDriver();;

    @BeforeClass
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "C:/Users/idsay/Downloads/chromedriver-win64/chromedriver.exe");
        //driver = new ChromeDriver();
    }

    @Test
    public void firstTest(){
        driver.get("https://wikipedia.com");
    }

    @AfterClass(enabled = false)
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
