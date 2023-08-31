package apitesting;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

public class C09_Get_BodyTekrarlardanKurtulma {
    /*
     C9_Get_BodyTekrarlardanKurtulma
https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request gonderdigimizde donen Response’un,
status code’unun 200,
ve content type’inin application-json, ve response body’sindeki
“firstname”in, “Susan”,
ve “lastname”in, “Jackson”,
ve “totalprice”in, 612,
ve “depositpaid”in, false,
	ve “additionalneeds”in, “Breakfast” oldugunu test edin
     */
    @Test
    public void bodyTekrarlardanKurtulma(){
        String url="https://restful-booker.herokuapp.com/booking/10";
        Response response=given().when().get(url);

        response
                .then()
                .assertThat()
                .statusCode(200)
                .body("firstname", containsString("Jim")
                ,"lastname", equalTo("Ericsson")
                ,"totalprice", equalTo(314)
                ,"depositpaid",equalTo(false)
                ,"additionalneeds",equalTo("Breakfast"));
        response.prettyPrint();
    }
}
