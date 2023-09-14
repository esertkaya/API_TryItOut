package apitesting;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_JUnitIleTest {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url’ine bir GET request yolladigimizda
    donen response body’sinin asagida verilen ile ayni oldugunu test ediniz
Response body : (expectedData)
{
“userId”: 3,
“id”: 22,
“title”: “dolor sint quo a velit explicabo quia nam”,
“body”: “eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
um mollitia molestiae aut atque rem suscipit\nnam impedit esse”
}
     */
    @Test
    public void expectedData(){
        //EndPoint
        String url="https://jsonplaceholder.typicode.com/posts/22";
        //Expected Data Hazirlama
        JSONObject expectedData=new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\\nsed omnis non odio\\nexpedita ear\n" +
                "um mollitia molestiae aut atque rem suscipit\\nnam impedit esse");

        Response response=given().when().get(url);
        //Karsilastirma islemi yapabilmek icin kodlarimiza response verilerini okutmamiz gerekir.
        //Bunun icin response'la donen verileri okuyacak bir obje olustururuz.
        //Bunu da JSonPath class'i ile yapabiliriz
        JsonPath resJP=response.jsonPath();
        Assert.assertEquals(expectedData.get("userId"),resJP.get("userId"));
        Assert.assertEquals(expectedData.get("id"),resJP.get("id"));
        Assert.assertEquals(expectedData.get("title"),resJP.get("title"));
     //   Assert.assertEquals(expectedData.get("body"),resJP.get("body"));
        response.prettyPrint();




    }

}
