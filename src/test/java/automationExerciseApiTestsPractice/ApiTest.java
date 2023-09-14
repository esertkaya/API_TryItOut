package automationExerciseApiTestsPractice;

import baseurl.BaseUrl_AutomationExercise;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.junit.Test;

public class ApiTest extends BaseUrl_AutomationExercise {
    @Test
            public void test01(){

        // Endpoint URL
        specAutomationExercise.pathParams("pp1","products","pp2","search");

        // Aranacak ürün adı
        String productName = "tshirt";

        // JSON objesi oluşturma
        JSONObject requestParams = new JSONObject();
        requestParams.put("search_product", productName);

        // RestAssured yapılandırması

        // POST isteğini gönderme
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestParams.toString())
                .when()
                .post("/{pp1}","?{pp2}");

        // Yanıtı yazdırma
        if (response.getStatusCode() == 200) {
            System.out.println("Response: " + response.asString());
        } else {
            System.out.println("Error! Status Code: " + response.getStatusCode());
        }
    }
}