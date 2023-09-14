package practice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.*;

public class Practice2 {
    /*
    https://jsonplaceholder.typicode.com/todos/23
            When
                Kullanıcı URL'e bir GET request gönderir
            Then
                HTTP Status Code 200 olmalı
            And
                Content Type “application/json” olmalı
            And
                “title” şu metni içermeli: “et itaque necessitatibus maxime molestiae qui quas velit”,
            And
                “completed” değeri false olmalı
            And
                “userId” değeri 2 olmalı*/

    @Test
    public void test02(){
        RestAssured.baseURI="https://jsonplaceholder.typicode.com";
        RestAssured.basePath="/todos/23";

   //Response response=given().when().get();
                 given()
                        .when()
                        .get()
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .body("title", containsString("et itaque necessitatibus maxime molestiae qui quas velit")
                        ,"completed",equalTo(false),"userId",equalTo(2));
              //  .body("completed",equalTo(false))
              //  .body("userId",equalTo(2));

     //   response.prettyPrint();



    }



}
