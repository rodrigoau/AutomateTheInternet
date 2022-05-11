package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {

    public static WebDriver driver;
    public static WebDriverWait wait;
    final static String browser = "chrome_manager";

    //Static Factory
    /*public static WebDriver getDriverManager(){
        if(driver == null){
            WebDriverManager.firefoxdriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }*/

    public static WebDriver getDriver(){
        if(driver == null){
            switch (browser) {
                case "chrome" -> {
                    System.setProperty("webdriver.chrome.driver", "C:/explorers_drivers/chromedriver.exe");
                    //driver.manage().deleteAllCookies();
                    //driver.manage().deleteCookieNamed("cookiename");
                    //DesiredCapabilities ch = new DesiredCapabilities();
                    //ch.acceptInsecureCerts();
                    ChromeOptions co = new ChromeOptions();
                    //co.merge(ch);
                    driver = new ChromeDriver();
                }
                case "firefox" -> {
                    System.setProperty("webdriver.gecko.driver", "C:/drivers_explorers/geckodriver.exe");
                    driver = new FirefoxDriver();
                }
                case "chrome_manager" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                default -> {
                    System.setProperty("webdriver.edge.driver", "C:/drivers_explorers/msedgedriver.exe");
                    driver = new EdgeDriver();
                }
            }
        }
        return driver;
    }

    /*public static WebDriverWait getWebDriverWait(){
        if(wait == null){
            wait = new WebDriverWait(getDriverManager(), 5);
        }
        return wait;
    }*/

}
