package apitesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C07_Get_ResponseBodyTesti {
    /*
    C7_Get_ResponseBodyTesti
https://jsonplaceholder.typicode.com/posts/44 url’ine bir GET request yolladigimizda
donen Response’in
status code’unun 200,
ve content type’inin Aplication.JSON,
ve response body’sinde bulunan userId’nin 5,
	ve response body’sinde bulunan title’in “optio dolor molestias sit” oldugunu test edin.
     */

    @Test
            public void test01(){

    String url="https://jsonplaceholder.typicode.com/posts/44";
  Response response=given().when().get(url);
  response
          .then()
          .assertThat()
          .statusCode(200)
          .contentType("Application/JSON")
          .body("userId", Matchers.equalTo(5))
                  .body("title",Matchers.equalTo("optio dolor molestias sit"));
  response.prettyPrint();




}
}
