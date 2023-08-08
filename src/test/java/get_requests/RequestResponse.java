package get_requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestResponse {
    public static void main(String[] args) {

        String url="https://petstore.swagger.io/v2/pet/9898";
        Response response=given().when().get(url);
      //  response.prettyPrint();

        //status code nasil yazdirilir?
        System.out.println("Status Code: "+response.statusCode());

        //content type nasil yazdirilir?
        System.out.println("Content Type: "+response.contentType());

        //status line nasil yazdirilir?
        System.out.println("Status Line: "+response.statusLine());

    }
}
