package delete_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Delete01 extends JsonPlaceHolderBaseUrl {

     /*
        When
            I send DELETE Request to the Url https://jsonplaceholder.typicode.com/todos/198
        Then
            Status code is 200
            And Response body is {}
    */


    @Test
    public void delete01(){

        //Set the Url
        spec.pathParams("bir","todos","iki",198);

        // set expectedData : burada olsa da olur olmasa da
        Map<String,Object> expectedData=new HashMap<>();

        // Send the Delete request and get the response;

        Response response= given().spec(spec).when().delete("/{bir}/{iki}");

        response.prettyPrint();

        //Validate
        response.then().assertThat().statusCode(200);

        // silinen icerigin silindiginden emin olmak istiyorsak;

        Map<String,Object> actualData= response.as(HashMap.class);

        assertEquals(expectedData, actualData);


    }


}
