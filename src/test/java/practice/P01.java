package practice;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class P01 {
    /*
    {
    "userId": 1,
    "id": 1,
    "title": "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
    "body": "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"
  }
     */

    @Test
    public void test01(){
        String url="https://jsonplaceholder.typicode.com/posts";
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("userId",1);
        jsonObject.put("id",101);
        jsonObject.put("title","sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        jsonObject.put("userId","quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto");
        Response response=given().contentType(ContentType.JSON).when().body(jsonObject.toString()).post(url);
        response.prettyPrint();

        JsonPath jsonPath=response.jsonPath();
        Assert.assertEquals(jsonObject.get("userId"),jsonPath.get("userId"));
        Assert.assertEquals(jsonObject.get("id"),jsonPath.get("id"));
        Assert.assertEquals(jsonObject.get("title"),jsonPath.get("title"));
        Assert.assertEquals(jsonObject.get("title"),jsonPath.get("title"));


    }
    @Test
    public void test02(){
        /*
        {
    "userId": 4,
    "id": 31,
    "title": "ullam ut quidem id aut vel consequuntur",
    "body": "debitis eius sed quibusdam non quis consectetur vitae\nimpedit ut qui consequatur sed aut in\nquidem sit nostrum et maiores adipisci atque\nquaerat voluptatem adipisci repudiandae"
  }
         */
        String url="https://jsonplaceholder.typicode.com/posts";
        JSONObject reqBody=new JSONObject();
        reqBody.put("userId",4);
        reqBody.put("id",101);
        reqBody.put("title","ullam ut quidem id aut vel consequuntur");
        reqBody.put("body","debitis eius sed quibusdam non quis consectetur vitae\\nimpedit ut qui consequatur sed aut in\\nquidem sit nostrum et maiores adipisci atque\\nquaerat voluptatem adipisci repudiandae");

        Response response=given().contentType(ContentType.JSON).when().body(reqBody.toString()).post(url);
        response.prettyPrint();

        JsonPath path=response.jsonPath();
        Assert.assertEquals(reqBody.get("userId"),path.get("userId"));
        Assert.assertEquals(reqBody.get("id"),path.get("id"));
        Assert.assertEquals(reqBody.get("title"),path.get("title"));
        Assert.assertEquals(reqBody.get("body"),path.get("body"));
    }
}
