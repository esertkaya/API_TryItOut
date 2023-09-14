package automationExerciseApiTestsPractice;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class P02 {
    /*
    API URL: https://automationexercise.com/api/productsList
Request Method: POST
Response Code: 405
Response Message: This request method is not supported.
     */


    @Test
            public void p02(){


        String url="https://automationexercise.com/api/productsList";
        JSONObject postReq=new JSONObject();

        postReq.put("Response Code","405");
        postReq.put("Response message","This request method is not supported.");

        Response response=given().contentType(ContentType.JSON).when().body(postReq.toString()).post(url);

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body(containsString("This request method is not supported."));
        response.prettyPrint();




    }


}
