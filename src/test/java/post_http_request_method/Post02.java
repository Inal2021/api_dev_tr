package post_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.internal.mapping.Jackson1Mapper;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

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

        // Set the expected Data

        Todo expectedTodo = new Todo(55,"Tidy your room", false);

        //send the POST request and GET the response

        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedTodo).when().post("/{bir}");

        //response.prettyPrint();


        // Validation

        Todo actualTodo=response.as(Todo.class);

        assertEquals(expectedTodo.getUserId(),actualTodo.getUserId());
        assertEquals(expectedTodo.getTitle(),actualTodo.getTitle());
        assertEquals(expectedTodo.isCompleted(),actualTodo.isCompleted());


        // Eger Id yi de validate etmek istersek onu da bagimsiz olarak cagirip karsilastirabilriiz;

        expectedTodo.setId(201);

        assertEquals(expectedTodo.getId(),actualTodo.getId());

    }








}
