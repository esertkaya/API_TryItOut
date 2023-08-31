package automationExerciseApiTestsPractice;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P02 {
    /*
    API URL: https://automationexercise.com/api/productsList
Request Method: POST
Response Code: 405
Response Message: This request method is not supported.
     */


    @Test
            public void p02(){


        RestAssured.baseURI="https://automationexercise.com";
        RestAssured.basePath="/api/productsList";
        given()
                .when()
                .post()
                .statusCode();



    }


}
