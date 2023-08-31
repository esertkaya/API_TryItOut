package apitesting;

import io.restassured.response.Response;
import org.junit.Test;

import java.awt.geom.RectangularShape;

import static io.restassured.RestAssured.given;

public class ApiTesting01 {
    /*
C1_Get_ApiSorgulama
https://restful-booker.herokuapp.com/booking/10 url'ine bir GET request
gonderdigimizde donen Response'un,
status code'unun 200,
ve content type'inin application/json; charset=utf-8, ve Server isimli Header'in degerinin Cowboy,
ve status Line'in HTTP/1.1 200 OK
ve response suresinin 5 sn'den kisa oldugunu manuel olarak test ediniz.
 */

    //Url belirlenip url'e gidilecek
    //Expected data belirlenecek
    //Actual data belirlenecek
    //Assertion islemi yapilacak

    @Test
    public void get01(){
        String url="https://restful-booker.herokuapp.com/booking/83";
        Response response=given().when().get(url);
        response.prettyPrint();

    }
}
