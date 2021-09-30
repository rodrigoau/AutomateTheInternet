package pages;

import org.apache.commons.io.FileUtils;
import base.SetupFactory;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

import static base.DriverFactory.getDriver;

public class ABTestPage extends SetupFactory {

    WebDriver driver = getDriver();

    private final By linkToPage = By.linkText("A/B Testing");
    private final By titleTag = By.tagName("h3");

    private ABTestPage(){}

    //Singleton
    public static ABTestPage getAbTestPage(){
        return new ABTestPage();
    }

    public boolean reachPage(){
        boolean itPassed;
        try{
            WebElement link = driver.findElement(linkToPage);
            link.click();
            itPassed = true;
        }catch(Exception e){
            e.printStackTrace();
            itPassed = false;
        }
        return itPassed;
    }

    public ABTestPage getText(){
        WebElement title = driver.findElement(titleTag);
        String textTitle = title.getText();
        if(textTitle.equals("A/B Test Control")){
            System.out.println("It contains the correct text.");
        } else {
            System.out.println("It doesn't contains the correct text.");
        }
        return this;
    }

    public ABTestPage getScreenShot() throws IOException {
        File evidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(evidence, new File("src/test/screenshots/"+getClass().getSimpleName()+".png"));
        return this;
    }
}
