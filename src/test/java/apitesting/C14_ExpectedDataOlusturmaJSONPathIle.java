package apitesting;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
public class C14_ExpectedDataOlusturmaJSONPathIle {
    @Test
    public void test01(){
        String url = "https://jsonplaceholder.typicode.com/posts/22";
        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",3)
                .put("id",22)
                .put("title", "dolor sint quo a velit explicabo quia nam")
                .put("body", "eos qui et ipsum ipsam suscipit aut\\nsed omnis non odio\\nexpedita ear\n" +
                        "um mollitia molestiae aut atque rem suscipit\\nnam impedit esse");
        Response response = given().when().get(url);
        // Karsilastirma yapabilmek icin kodlarimiza response verilerini okutmamiz gerekir.
        //Bunun icin response ile donen verileri okuyacak bir obje olustururuz.
        // Bunu da JSONPath class i ile yapabiliriz.
        JsonPath resJP = response.jsonPath();
        assertEquals(expectedData.get("userId"), resJP.get("userId"));
        assertEquals(expectedData.get("id"), resJP.get("id"));
        assertEquals(expectedData.get("title"), resJP.get("title"));
    }
}
