package practice;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONPointer;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P02 {
    /*
    API URL: https://automationexercise.com/api/searchProduct
Request Method: POST
Request Parameter: search_product (For example: top, tshirt, jean)
Response Code: 200
     */
    @Test
    public void test01() {
        String url = "https://automationexercise.com/api/searchProduct";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Response Code", 200);
        jsonObject.put("Request Parameter", "search_product");

        Response response = given().contentType(ContentType.JSON).when().body(jsonObject.toString()).post(url);
        JsonPath jsonPath = response.jsonPath();
// 9       Assert.assertEquals(jsonObject.get("Response Code"),jsonPath.get(u ))
    }
}

