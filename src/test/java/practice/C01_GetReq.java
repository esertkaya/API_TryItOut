package practice;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetReq {

    @Test
    public void test01(){
        /*
       url:  https://regres.in/api/users/
        get request
        donen response yazdirin
         */

        String url="https://reqres.in/api/users/";
        Response response=given().when().get(url);
        response.prettyPrint();
    }
}
