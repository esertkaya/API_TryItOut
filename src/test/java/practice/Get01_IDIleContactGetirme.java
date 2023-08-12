package practice;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Get01_IDIleContactGetirme {
    @Test
    public void get01(){
        RestAssured.baseURI="https://thinking-tester-contact-list.herokuapp.com";
        RestAssured.basePath="/contacts/64d7dced9a694e00130f212d";
        String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NGQ3YzQ2YzlhNjk0ZTAwMTMwZjFmZDciLCJpYXQiOjE2OTE4NjMzMzh9.JRvWQsAj0-wI1ZAuKbfqFOR6YVcwzj98Tf0Hw5RJ05c";

        Response response=given()
                .auth()
                .oauth2(token)
                .when()
                .get();
        response.prettyPrint();

        response
                .then()
                .body("firstName",equalTo("John"))
                .body("lastName",equalToIgnoringCase("doe"))
                .body("email",not(equalTo("jdoe@faker.com")))
                .body("email",containsString("@fake.com"))
                .body("city",startsWith("Any"))
                .body("city",endsWith("town"))
                .body("stateProvince",anyOf(equalTo("KS"),equalTo("CA")))
                .body("country",allOf(equalTo("USA"),equalToIgnoringCase("usa")))
                .body("__v",greaterThan(-1));
    }

}
