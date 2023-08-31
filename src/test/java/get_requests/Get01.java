package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;


public class Get01 {

        /*
        Given
           https://restful-booker.herokuapp.com/booking/1
        When
           Kullanici URL'e bir get request gonderir
        Then
           HTTP Status Code 200 olmali
        And
           Content Type "application/json olmali"
        And
          "HTTP/1.1 200 OK olmali"
         */
        @Test
        public void get01() {
            //1.yontem
          //  String url= "https://restful-booker.herokuapp.com/booking/1";
            //2.yontem
           RestAssured.baseURI="https://restful-booker.herokuapp.com";
           RestAssured.basePath="/booking/1";

       //   Response response= given().
                  //  when().
                 //   get(url);//birinci yontemde yazarken get'tyen sonraki paranteze string'e verdigimiz ismi yazariz
                  //  get();//ikinci yontemde Rest Assured kutuphanesini baseURL ve BasePAth kullandigimiz icin bos birakabiliriz
                  //  response.prettyPrint();

               //     response.
                          //  then().
                          //  statusCode(200).
                          //  contentType("application/json").
                          //  statusLine("HTTP/1.1 200 OK");



                    given()
                            .get()
                            .then()
                            .statusCode(200)
                            .contentType("application/json")
                            .statusLine("HTTP/1.1 200 OK"); //Bu yontem daha pratik bir zinci olusturuyor
                                                              //Response kullanmadan daha kisa bir sekilde yazabiliyoruz





    }
}