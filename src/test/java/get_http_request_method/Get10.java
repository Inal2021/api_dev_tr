package get_http_request_method;

import base_urls.DummyApiBaseUrl;

import com.google.gson.Gson;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.Employee;

import java.io.IOException;
import java.lang.runtime.ObjectMethods;

import static io.restassured.RestAssured.given;
import static junit.framework.TestCase.assertTrue;


public class Get10 extends DummyApiBaseUrl {
// SERIALIZATION ve DESERIALIZATION ISLEMI
      /*
      When
        I send a GET Request to the URL http://dummy.restapiexample.com/api/v1/employees
       Status code should be 200
       Use Gson and ObjectMapper
       make sure you have 24 records for data
  */

    @Test
    public void get10() throws IOException {

        spec.pathParams("bir","api","iki","v1","uc","employees");

        Response response=given().spec(spec).when().get("/{bir}/{iki}/{uc}");

//        response.prettyPrint();

        ObjectMapper obj=new ObjectMapper();

        Employee employees=obj.readValue(response.asString(), Employee.class); // readValue() response dan gelen datayi okuyup Employee classina dönüstürecek.

        System.out.println(employees.getMessage());
        System.out.println(employees.getStatus());

//        System.out.println(employees.getData().get(7).getEmployee_name());
//        System.out.println(employees.getData().get(7).getEmployee_salary());
//        System.out.println(employees.getData().get(7).getEmployee_age());

        // Yukaridaki islemi for loop ile tanimlayalim;

        for (int i = 0; i < employees.getData().size(); i++) {
            System.out.println("The Person "+(i+1)+" ID: "+employees.getData().get(i).getId());
            System.out.println("The Person "+(i+1)+" name: "+employees.getData().get(i).getEmployee_name());
            System.out.println("The Person "+(i+1)+" salary: "+employees.getData().get(i).getEmployee_salary());
            System.out.println("The Person "+(i+1)+" age: "+employees.getData().get(i).getEmployee_age());
            System.out.println("==============================");
        }

        // Validate

        assertTrue("Not find 24 records",employees.getData().size() ==24); // Bizim datamizin toplam sayisini kontrol edecegiz.


    }


    @Test
    public void get11(){

        spec.pathParams("bir","api","iki","v1","uc","employees");

        Response resp=given().spec(spec).when().get("/{bir}/{iki}/{uc}");

        Gson gson=new Gson();

        Employee employees=gson.fromJson(resp.asString(), Employee.class);

        System.out.println("Data size: "+employees.getData().size());

        // Validate

        assertTrue("Can not find 24 records",employees.getData().size() ==24);


    }



    

}
