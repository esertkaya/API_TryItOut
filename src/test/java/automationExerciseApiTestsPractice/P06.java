package automationExerciseApiTestsPractice;

import baseurl.BaseUrl_AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import java.lang.module.ResolutionException;

import static io.restassured.RestAssured.given;

public class P06 extends BaseUrl_AutomationExercise {
    /*
    API URL: https://automationexercise.com/api/searchProduct
Request Method: POST
Response Code: 400
Response Message: Bad request, search_product parameter is missing in POST request.
     */
    @Test
    public void test01(){
      specAutomationExercise.params("pp1","api","pp2","searchProduct");

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("Response Code",400);
        jsonObject.put("Response Message","Bad request, search_product parameter is missing in POST request.");

        Response response=given().spec(specAutomationExercise).contentType(ContentType.JSON).when().body(jsonObject.toString())
                .post("/{pp1}","/{pp2}");

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("Bad request, search_product parameter is missing in POST request."));
        response.prettyPrint();
    }
}
