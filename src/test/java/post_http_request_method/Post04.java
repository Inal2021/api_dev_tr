package post_http_request_method;

import base_urls.MedunnaBaseUrl;
import com.github.javafaker.Faker;
import org.junit.Test;
import pojos.Registrant;

import static utilities.WriteToTxt.saveRegistrantData;

public class Post04 extends MedunnaBaseUrl {

//Send the post request to the url https://medunna.com/api/register
    /*
    create a new user for Medunna project
    status code should be 200
                {
              "activated": true,
              "authorities": [
                "string"
              ],
              "createdBy": "string",
              "createdDate": "2022-01-03T19:25:02.075Z",
              "email": "string",
              "firstName": "string",
              "id": 0,
              "imageUrl": "string",
              "langKey": "string",
              "lastModifiedBy": "string",
              "lastModifiedDate": "2022-01-03T19:25:02.075Z",
              "lastName": "string",
              "login": "string",
              "password": "string",
              "ssn": "string"
            }

                 */


    @Test
    public void post04(){

        // set the url
        spec.pathParams("bir","api","iki","register");

        // set the expected

        Registrant registrant= new Registrant();
        Faker faker=new Faker();

        registrant.setFirstName(faker.name().firstName()); // ercekci ama gercek olamayn data aldik. Java Faker sayesinde
        registrant.setLastName(faker.name().lastName());
        registrant.setLangKey("en");
        registrant.setPassword(faker.internet().password(8,25,true,true));
        registrant.setEmail(registrant.getFirstName()+registrant.getLastName()+"@gmail.com");
        registrant.setLogin(registrant.getFirstName()+registrant.getLastName());
        registrant.setSsn(faker.idNumber().ssnValid());


        String fileName;

//        saveRegistrantData(fileName, registrant);



    }




}
