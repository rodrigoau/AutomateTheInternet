package tests;

import base.SetupFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicControlsPage;

import static base.DriverFactory.getDriver;
import static pages.DynamicControlsPage.getDynamicControlsPage;


public class DynamicTest extends SetupFactory {

    WebDriver driver = getDriver();

    DynamicControlsPage dc = getDynamicControlsPage();

    @Test(enabled = false)
    public void reachPageTest(){
        Assert.assertTrue(dc.reachPage(), "Could not reach page");
    }

    @Test(enabled = false)
    public void removeTest(){
        dc.remove();
    }

    @Test
    public void secondRemoveTest(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        dc.startTextFluent();
    }


}
