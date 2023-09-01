package practice;

import io.restassured.response.Response;
import org.junit.Test;

import java.lang.module.ResolutionException;

import static io.restassured.RestAssured.given;

public class C02_GetReqTest {

    @Test
    public void test02(){
        /*
        url : https://reqres.in/api/users/2
        status code: 200
        The content type: application/json; charset=utf-8
        Server isimli header: cloudflare
        statuse line: HTTP/1.1 200 OK
         */

        String url="https://reqres.in/api/users/2";
        Response response=given().when().get(url);

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");
        response.prettyPrint();

    }
}
