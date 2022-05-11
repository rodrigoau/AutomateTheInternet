package tests.api;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class RestAssuredAPITesting {

    public String q = "London";
    public String appid = "567c0b3881b68db79a2a1b0da0c82f0f";


    @Test
    public void getWeather(){
        RestAssured.baseURI = "https://api.openweathermap.org";
        String response = given().log().all().header("Content-Type", "application/json")
                .when().post("/data/2.5/weather?q="+q+"&appid="+appid).then().assertThat().statusCode(200)
                .extract().response().asString();

        System.out.println(response);

        JsonPath js = new JsonPath(response);
        System.out.println(js);
        //String key = js.get("coord");
        //System.out.println(key);
    }
}
