package pages;

import base.SetupFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static base.DriverFactory.*;

public class DynamicControlsPage extends SetupFactory {

    WebDriver driver = getDriver();
    private final By linkToPageElement = By.linkText("Dynamic Controls");
    private final By removeButtonElement = By.xpath("/html/body/div[2]/div/div[1]/form[1]/button");
    private final By finalTextElement = By.xpath("//*[@id='message']");
    // It's gone!
    private final By startButtonElement = By.xpath("/html/body/div[2]/div/div/div[1]/button");
    private final By helloWorldElement = By.xpath("/html/body/div[2]/div/div/div[3]/h4");

    private DynamicControlsPage(){};

    public static DynamicControlsPage getDynamicControlsPage(){
        return new DynamicControlsPage();
    }

    public boolean reachPage(){
        boolean itPassed;
        try{
            WebElement link = driver.findElement(linkToPageElement);
            link.click();
            itPassed = true;
        }catch(Exception e){
            e.printStackTrace();
            itPassed = false;
        }
        return itPassed;
    }

    public DynamicControlsPage remove() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement button = driver.findElement(removeButtonElement);
        button.click();
        WebElement text = driver.findElement(finalTextElement);
        if(text.isDisplayed())
            System.out.println("It is displaying");
        else
            System.out.println("It is not displaying");

        return this;
    }

    public DynamicControlsPage startTextExplicit(){
        WebElement button = driver.findElement(startButtonElement);
        button.click();
        WebElement text = driver.findElement(helloWorldElement);
        String hw = text.getText();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElement(text, "Hello World!"));
        /*
        if(text.isDisplayed())
            System.out.println("It is displaying");
        else
            System.out.println("It is not displaying");
        */
        return this;
    }

    public DynamicControlsPage startTextFluent(){
        WebElement button = driver.findElement(startButtonElement);
        button.click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement text = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                if (driver.findElement(helloWorldElement).isDisplayed()) {
                    System.out.println("is displayed");
                    return driver.findElement(helloWorldElement);
                } else {
                    return null;
                }
            }
        });
        return this;

    }


}
