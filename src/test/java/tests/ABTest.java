package tests;

import base.SetupFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ABTestPage;

import java.io.IOException;

import static pages.ABTestPage.getAbTestPage;

public class ABTest extends SetupFactory {

    ABTestPage abPage = getAbTestPage();
    String dataName;

    @Test(enabled = false)
    public void getData(){
        dataName = properties.getProperty("data.name");
        System.out.println(dataName);
    }

    @Test(description = "Open page.")
    public void getText() throws IOException {
        Assert.assertTrue(abPage.reachPage(), "Could not reach page");
        abPage.getText().getScreenShot();
    }


}
