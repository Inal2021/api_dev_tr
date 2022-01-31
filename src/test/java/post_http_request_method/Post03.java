package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static data.JsonPlaceHolderData.expectedDataSetup;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Post03 extends JsonPlaceHolderBaseUrl {

     /*
       When
             I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
             with the request body {
                                   "userId": 55,
                                   "title": "Tidy your room",
                                   "completed": false
                                  }
       Then
           Status code is 201
           And response body is like {
                                       "userId": 55,
                                       "title": "Tidy your room",
                                       "completed": false,
                                       "id": 201
                                     }

                                     userName: "admin"
                                     password: "nimda"
    */

    @Test
    public void post03() {

        // set the base url
        spec.pathParams("bir","todos");

        // set the expected data
        // BURASI ICIN DATA PACKAGE de JsonPlaceHolderData olusturduk.

        Map<String, Object> expectedData = expectedDataSetup();


        // Send the POST request and GET response / Post request yap ve response elde et

        Response response= given().spec(spec).auth().basic("admin","nimda")
                .contentType(ContentType.JSON)
                .body(expectedData).when().post("/{bir}");

        response.prettyPrint();

        // Validate

        response.then().assertThat().statusCode(201).body("userId", equalTo(55),
                "title", equalTo("Tidy your room"), "completed", equalTo(false));


    }


}
