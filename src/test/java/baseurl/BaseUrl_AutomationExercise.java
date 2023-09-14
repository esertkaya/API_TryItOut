package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseUrl_AutomationExercise {
    protected RequestSpecification specAutomationExercise;

    @Before
    public void setUP (){
        specAutomationExercise =new RequestSpecBuilder()
                .setBaseUri("https://automationexercise.com")
                .build();
    }

}
