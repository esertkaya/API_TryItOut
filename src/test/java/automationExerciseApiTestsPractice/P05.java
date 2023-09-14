package automationExerciseApiTestsPractice;

import baseurl.BaseUrl_AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

public class P05 extends BaseUrl_AutomationExercise {
@Test
    public void test01(){
    specAutomationExercise.pathParam("pp1","products");
    String productName="tshirt";

    /*
    API URL: https://automationexercise.com/products?search
Request Method: POST
Request Parameter: search_product (For example: top, tshirt, jean)
Response Code: 200
Response JSON: Searched products list
     */
    JSONObject product=new JSONObject();
    product.put("search_product",productName);
    Response response=given().spec(specAutomationExercise).contentType(ContentType.JSON).when().post("/{pp1}");

    response
            .then()
            .assertThat()
            .statusCode(403);
    response.prettyPrint();
}
}
