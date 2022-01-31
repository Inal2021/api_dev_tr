package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.internal.mapping.Jackson1Mapper;
import org.junit.Test;

public class Post02 extends JsonPlaceHolderBaseUrl {

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
     */

    @Test
    public void post02(){

        // Set the URL

        spec.pathParams("bir","todos");

        


    }








}
