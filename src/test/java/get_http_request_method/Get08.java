package get_http_request_method;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Todo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends JsonPlaceHolderBaseUrl {

 /*
     Given
            https://jsonplaceholder.typicode.com/todos/2
     When I send a Get Request
     Then the actual data should be as following;
        {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    }
     */

    @Test
    public void get08(){

        // Set the URL
        spec.pathParams("bir","todos","iki",2);

        // Set the expected data => beklenen datayi olustur

        Map<String, Object> expectedData= new HashMap<>();

        expectedData.put("userId", 1);
        expectedData.put("id", 2);
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);



        // Send the Get Request and Get the response / Talep yolla cevap al

        Response response=given().spec(spec).when().get("/{bir}/{iki}");

        // Validation => kontrol et  NOT: asagida mesaj kismi eger bir karsilastirma hatasi varsa consolde görünür.

        Map<String, Object> actualData =response.as(HashMap.class);

        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals("Beklenen veriler ve karsilastirilan veriler farkli",expectedData.get("id"), actualData.get("id"));
        assertEquals("Beklenen veriler ve karsilastirilan veriler farkli",expectedData.get("title"), actualData.get("title"));
        assertEquals("Beklenen veriler ve karsilastirilan veriler farkli",expectedData.get("completed"), actualData.get("completed"));



    }


    @Test
    public void testWithPojo() {

        // Set the URL

        spec.pathParams("bir","todos","iki",2);

        // Set the Expected Data

        Todo expectedTodo = new Todo(1,2, "quis ut nam facilis et officia qui", false);

        System.out.println(expectedTodo);

        // Send the GET Request and GET the Response

        Response response= given().spec(spec).when().get("/{bir}/{iki}");

        //2. YOL ==>  Validation

        Todo actualTodo= response.as(Todo.class);

        System.out.println("gelen actual data : "+actualTodo);

        assertEquals("Beklenen Data karsilasilan ile uyusmadi", expectedTodo.getUserId(), actualTodo.getUserId());
        assertEquals("Beklenen Data karsilasilan ile uyusmadi", expectedTodo.getTitle(), actualTodo.getTitle());
        assertEquals("Beklenen Data karsilasilan ile uyusmadi", expectedTodo.getId(), actualTodo.getId());
        assertEquals("Beklenen Data karsilasilan ile uyusmadi", expectedTodo.isCompleted(), actualTodo.isCompleted());


    }


}
