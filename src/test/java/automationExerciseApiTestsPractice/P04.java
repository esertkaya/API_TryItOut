package automationExerciseApiTestsPractice;

import baseurl.BaseUrl_AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P04 extends BaseUrl_AutomationExercise {
    /*

   API URL: https://automationexercise.com/api/brandsList
Request Method: PUT
Response Code: 405
Response Message: This request method is not supported.
     */
    @Test
    public void test01(){
String url="https://automationexercise.com/api/brandsList";
       specAutomationExercise.params("pp1","api","pp2","brandsList");
        JSONObject reqBody=new JSONObject();
        reqBody.put("Response Code",405);
        reqBody.put("Response Message","This request method is not supported");
        Response response=given().spec(specAutomationExercise).contentType(ContentType.JSON).when().body(reqBody.toString()).put(url);

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body(Matchers.containsString("This request method is not supported"));



    // .extract().response();
        String allBrandsList=response.asPrettyString();
        response.prettyPrint();







    }
}
