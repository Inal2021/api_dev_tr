package get_http_request_method;

import base_urls.DummyApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get07 extends DummyApiBaseUrl {


    @Test
    public void get07(){

        spec.pathParams("bir","api","iki","v1","uc","employee","dort",7);

        Response response=given().spec(spec).when().get("/{bir}/{iki}/{uc}/{dort}");

//        response.prettyPrint();


        // Validation 1. Yol

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON)
                .body("data.employee_name",equalTo("Herrod Chandler"))
                .body("data.employee_salary",equalTo(137500))
                .body("data.id",equalTo(7));

        // Validation 2. Yol

        JsonPath json=response.jsonPath();

        System.out.println(json.getString("data"));
        System.out.println(json.getString("data.employee_salary"));
        System.out.println(json.getInt("data.employee_salary"));

        String name=json.getString("data.employee_name");
        int salary=json.getInt("data.employee_salary");
        int id=json.getInt("data.id");

        System.out.println(name+" "+salary+" "+id);

        // HARD ASSERTION => Scenario calisir ve ilk hatada execution durur. Asagida Herrod yerine Herod yazdik ve hemen hata verdi

        assertEquals(json.getString("data.employee_name"),"Herrod Chandler");
        assertEquals(json.getInt("data.employee_salary"),137500);
        assertEquals(json.getInt("data.id"),7);

        // SOFT ASSERTION => tüm scenariolari calistirir ve en sonda bütün hatalari ortaya cikarir.
        // Asagida iki veriyi de degistirdik ve bize hata mesajinda her ikisinin de hatali oldugu bilgisi geldi.

        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(json.getInt("data.employee_salary"),137500);
        softAssert.assertEquals(json.getInt("data.id"),7);
        softAssert.assertEquals(json.getString("data.employee_name"),"Herrod Chandler");

        softAssert.assertAll();

    }



}
