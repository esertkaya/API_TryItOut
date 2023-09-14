package practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

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

    public static class practice2 {
        /*
            Given
               https://restful-booker.herokuapp.com/booking/1
            When
               Kullanici URL'e bir get request gonderir
            Then
               HTTP Status Code 200 olmali
            And
               Content Type "application/json"
            And
              "HTTP/1.1 200 OK olmali"
    */
        @Test
        public void test01(){
        /*    String url="https://restful-booker.herokuapp.com/booking/1";

            Response response=given().when().get(url);

            response
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 200 OK");
            response.prettyPrint();

         */
            RestAssured.baseURI="https://restful-booker.herokuapp.com";
            RestAssured.basePath="/booking/1";

            given()
                    .get()
                    .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json")
                    .statusLine("HTTP/1.1 200 OK");
        }
    }
}
