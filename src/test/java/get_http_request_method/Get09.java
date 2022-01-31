package get_http_request_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerokuappBaseUrl {

     /*
        When
	 		I send GET Request to https://restful-booker.herokuapp.com/booking/2
	 	Then
	 		Response body should be like that;
{
    "firstname": "Mary",
    "lastname": "Ericsson",
    "totalprice": 365,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2015-06-21",
        "checkout": "2019-09-23"
    }
}
     */

    @Test
    public void get09(){

        //Set the URL

        spec.pathParams("bir","booking","iki",2);

        // Set the expected data

        Map<String, Object> bookingdates=new HashMap<>();

        bookingdates.put("checkin","2015-06-21");
        bookingdates.put("checkout","2019-09-23");


        Map<String, Object> expectedData=new HashMap<>();

        expectedData.put("firstname","Mary");
        expectedData.put("lastname","Ericsson");
        expectedData.put("totalprice",365);
        expectedData.put("depositpaid",true);
        expectedData.put("bookingdates",bookingdates);

        // Set get request and get response

        Response response= given().spec(spec).when().get("/{bir}/{iki}");

//       System.out.println(expectedData);
//
//        response.prettyPrint();

        // Validation

        Map<String, Object> actualData= response.as(HashMap.class);

        assertEquals("Datalar birbiri ile uyumlu degil", expectedData.get("firstname"),actualData.get("firstname"));
        assertEquals("Datalar birbiri ile uyumlu degil", expectedData.get("lastname"),actualData.get("lastname"));
        assertEquals("Datalar birbiri ile uyumlu degil", expectedData.get("totalprice"),actualData.get("totalprice"));
        assertEquals("Datalar birbiri ile uyumlu degil", expectedData.get("depositpaid"),actualData.get("depositpaid"));

        assertEquals("Datalar birbiri ile uyumlu degil", bookingdates.get("checkin"), ((Map) actualData.get("bookingdates")).get("checkin"));
        assertEquals("Datalar birbiri ile uyumlu degil", bookingdates.get("checkout"), ((Map) actualData.get("bookingdates")).get("checkout"));



    }


}
