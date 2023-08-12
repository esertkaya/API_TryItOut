package get_requests;

import io.restassured.RestAssured;
import org.junit.Test;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;


public class Get02 {
   /*
   Given
           https://restful-booker.herokuapp.com/booking/0
        When
           Kullanici URL'e bir get request gonderir
        Then
           HTTP Status Code 404 olmali
        And
           Content Type "application/json olmali"
        And
          "HTTP/1.1 200 OK olmali"
        And
          Response body "TechProEd" icermemeli
        And
           Server degeri "Cowboy" olmali
    */




    @Test
    public void get02(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="/booking/1";
          given()
                  .when()
                  .get()
                  .then()
                  .statusCode(404)
                  .statusLine("HTTP/1.1 404 Not Found")
                  .body(containsString("Not Found"))
                  .body(not(containsString("TechProEd")))
                  .header("Server","Cowboy");


    }
}
