package tests.first;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class SomeApiTest {

    @Test
    public void getJokeTest(){
        RestAssured.baseURI = "https://official-joke-api.appspot.com";

        Response response = given().
                contentType(ContentType.JSON).
                when().
                get("/random_joke").
                then().
                extract().response();

        Assert.assertEquals(200, response.statusCode());

//        String resp = response.asString();
//        System.out.println(resp);

    }
}
