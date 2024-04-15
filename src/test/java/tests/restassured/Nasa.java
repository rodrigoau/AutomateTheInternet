package tests.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.*;

public class Nasa {

    String insightUrl;
    String token;
    String params;
    String url;
    Response response;

    @BeforeClass
    public void setUp() throws IOException {
        String propFile = "src/test/resources/data.properties";
        Properties prop = new Properties();
        prop.load(new FileInputStream(new File(propFile)));
        this.insightUrl = prop.getProperty("nasa.api.insight.url");
        this.token = prop.getProperty("nasa.api.token");
        this.params = prop.getProperty("nasa.api.params");
        this.url = insightUrl + token + params;
        RestAssured.baseURI = url;
        response = given().log().all().header("Content-Type", "application/json").get(insightUrl + token + params);
    }

    @Test
    public void testCode(){
        Assert.assertEquals(response.getStatusCode(),200);
    }

}
