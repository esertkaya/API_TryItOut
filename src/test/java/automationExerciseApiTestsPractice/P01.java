package automationExerciseApiTestsPractice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.JSONAssertion;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P01 {
    @Test
    public void test01(){

        /*
        API URL: https://automationexercise.com/api/productsList
Request Method: GET
Response Code: 200
Response JSON: All products list
         */

        String url="https://automationexercise.com/api/productsList";
        Response response= given().when().get(url);
        response
                .then()
                .assertThat()
                .statusCode(200);
        response.prettyPrint();




    }
}
