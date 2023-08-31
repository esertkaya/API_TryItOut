package apitesting;

import org.json.JSONObject;
import org.junit.Test;



public class C05_InnerJsonObject {
    /*
      Asagidaki JSON Objesini olusturup konsolda yazdirin.
{
“firstname”:“Jim”, “additionalneeds”:“Breakfast”, “bookingdates”:{
“checkin”:“2018-01-01”,
“checkout”:“2019-01-01”
},
“totalprice”:111, “depositpaid”:true, “lastname”:“Brown”
}
     */

    @Test
    public void test01(){
        JSONObject innerObject=new JSONObject();
        innerObject.put("checkin","2018-01-01");
        innerObject.put("checkout","2019-01-01");

        JSONObject outerObject=new JSONObject();
        outerObject.put("firstname","Jim");
        outerObject.put("lastname","Brown");
        outerObject.put("additionalneeds", "Breakfast");
        outerObject.put("bookingdates",innerObject);
        outerObject.put("totalprice","111");
        outerObject.put("depositpaid","true");
        System.out.println("JsonObject: "+outerObject);



    }




}
