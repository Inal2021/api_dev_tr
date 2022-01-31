package get_http_request_method;

import base_urls.HerokuappBaseUrl;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class Get01 extends HerokuappBaseUrl {

    // GHERKIN KEY WORDS

    // given => Baslanginc islemini temsil eder (pre-requisite)
    // when  => islemin action kismini tanimlar
    // AND  => tekrar eden islemleri gösterir
    // Then => Islemin sonunu ve Validation'u gösterir


  /*
  GHERKIN ile senaryo örnegi;

    Given
           https://restful-booker.herokuapp.com/booking/3
    When
         user sends a request to the url
    Then
         HTTP Status code should be 200
     And
         ContentType should be JSON
     And
        Status Line should be HTTP/1.1 200 OK
     */

@Test
    public void get01(){

    String endpoint= "https://restful-booker.herokuapp.com/booking/2";

    Response response= given().when().get(endpoint);

    response.prettyPrint();

}

@Test
    public void test(){

    //https://restful-booker.herokuapp.com/booking/3

//    RequestSpecification spec;
//
//    spec = new RequestSpecBuilder().setBaseUri("https://restful-booker.herokuapp.com").build();

    // HerokuappBaseUrl class i extend ettigimiz icin asagidaki spec i kullanabiliyoruz artik. Böylelikle yukariyi sildik.

    // set the url  ==>> URL yi set et, yerlestir
    spec.pathParams("bir","booking","iki",3);

    // /{bir}/{iki}   ==>> GET request yap, response al...
    Response response= given().spec(spec).when().get("/{bir}/{iki}");

    response.prettyPrint();

    //Validation islemi

    response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

}



}
