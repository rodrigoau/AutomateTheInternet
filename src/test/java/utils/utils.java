package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import pages.WikipediaPageSingleton;

import java.io.File;
import java.io.IOException;

import static base.DriverFactory.driver;

public class utils {

    public void takeScreenShot() throws IOException {
        File evidence = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(evidence, new File("src/test/screenshots/"+getClass().getSimpleName()+".png"));
    }

    public void changeToIFrame(WebElement selectedIframe){
        driver.switchTo().frame(selectedIframe);
    }

    public void backToDefaultContext(){
        driver.switchTo().defaultContent();
    }

    public void handlePopup(){
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();
        driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("Text");
    }
}
