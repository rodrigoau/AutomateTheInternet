package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static base.DriverFactory.getDriver;
import static base.DriverFactory.getWebDriverWait;

public class SetupFactory {
    WebDriver driver;
    WebDriverWait wait;

    private final String propFile = "src/test/resources/data.properties";
    protected Properties properties = new Properties();

    @BeforeSuite
    public void setUp() throws IOException {
        properties.load(new FileInputStream(new File(propFile)));
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        wait = getWebDriverWait();
    }

    @AfterSuite(enabled = false)
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
