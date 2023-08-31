package apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C10_Post_JsonPathIleBodyTesti {
    /*
    C09_Post_JsonPathIleBodyTesti
https://restful-booker.herokuapp.com/booking url’ine asagidaki body’ye sahip bir POST
request gonderdigimizde
{
donen Response’un,
status code’unun 200,
ve content type’inin application-json, ve response body’sindeki
“firstname”in,“Ahmet”, ve “lastname”in, “Bulut”,
ve “totalprice”in,500,
ve “depositpaid”in,false,
ve “checkin” tarihinin 2021-06-01 ve “checkout” tarihinin 2021-06-10 ve “additionalneeds”in,“wi-fi” olduğunu test edin
     */
    @Test
            public void postRequest(){

    String url="https://restful-booker.herokuapp.com/booking";
    JSONObject postReq1=new JSONObject();
    postReq1.put("checkin","2021-06-01");
    postReq1.put("checkout","2021-06-10");
    JSONObject postReq2=new JSONObject();
    postReq2.put("lastname","Bulut");
    postReq2.put("totalprice",500);
    postReq2.put("depositpaid","false");
    postReq2.put("bookingdates",postReq1);
    postReq2.put("additionalneeds","wi-fi");


        Response response=given().contentType(ContentType.JSON).when().body(postReq2.toString()).post(url);
        response.prettyPrint();

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application-json")
                .body("booking.firstname",equalTo("Ahmet"),"booking.lastname",equalTo("Bulut")
                ,"booking.totalprice",equalTo(500),"booking.depositpaid",equalTo("false")
                        ,"booking.bookingdates.checkin",equalTo("2021-06-01")
                        ,"booking.bookingdates.checkout",equalTo("2021-06-10")
                        ,"booking.additionalneeds",equalTo("wi-fi"));
        response.prettyPrint();


    }

    }

