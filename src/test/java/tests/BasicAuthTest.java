package tests;

import base.SetupFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static base.DriverFactory.getDriver;

public class BasicAuthTest extends SetupFactory {

    WebDriver driver = getDriver();
    String username = "admin";
    String passsowrd = "admin";

    @Test
    public void setKeys(){
        driver.get("https://"+username+":"+passsowrd+"@"+"the-internet.herokuapp.com/basic_auth");
    }
}
