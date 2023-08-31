package automationExerciseApiTestsPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.junit.Assert.assertNotNull;

public class P03 {
    /*
    API URL: https://automationexercise.com/api/brandsList
Request Method: GET
Response Code: 200
Response JSON: All brands list
     */

    @Test
    public void test03() {
        String url = "https://automationexercise.com/api/brandsList";

        Response response = given().when().get(url);
        response
                .then()
                .statusCode(200)
                .and()
                .extract().response();
        String json=response.asPrettyString();
        assertNotNull(json);
        System.out.println(json);

    }
}