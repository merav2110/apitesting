package com.testing.merav.tests;

import com.testing.merav.infra.APICalls;
import com.testing.merav.infra.HttpResponse;
import com.testing.merav.infra.TestData;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.xml.ws.Response;
import java.util.HashMap;



public class Login {

    final private static Logger LOGGER = LoggerFactory.getLogger(CreateUser.class.getName());
    private TestData testData = new TestData();
    private HttpResponse httpResponse = new HttpResponse();

    @Test
    public void successfulLogin() { //tomer/1234

        //test input
        String username="tomer";
        String password = "1234";

        //response example
        /*
        {
            "username": "tomer",
            "token": "54766ced687c478cb5e39679cfb6dbd8"
        }
         */
        HashMap jsonAsMap = new HashMap();
        jsonAsMap.put("username", username);
        jsonAsMap.put("password", password);


        RestAssured.baseURI=testData.getRestAPI();
        String token =
        RestAssured.given().
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                body(jsonAsMap).
                when().
                post(APICalls.LOGIN.toString()).
                then().
                assertThat().
                statusCode( httpResponse.getSuccess()).
                extract().path("token");


        LOGGER.info("TokenUtils "+token);
    }

    @Test
    public void wrongPassword(){

        HashMap jsonAsMap = new HashMap();
        jsonAsMap.put("username", "tomer");
        jsonAsMap.put("password", "12345");

        RestAssured.baseURI=testData.getRestAPI();
        RestAssured.given().
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                body(jsonAsMap).
                when().
                post(APICalls.LOGIN.toString()).
                then().
                assertThat().
                statusCode(httpResponse.getWrongPassword());
    }

    @Test
    public void noSuchUserExist(){

        HashMap jsonAsMap = new HashMap();
        jsonAsMap.put("username", "tomerhhhhhhh");
        jsonAsMap.put("password", "1234");

        RestAssured.baseURI=testData.getRestAPI();
        RestAssured.given().
                accept(ContentType.JSON).
                contentType(ContentType.JSON).
                body(jsonAsMap).
                when().
                post(APICalls.LOGIN.toString()).
                then().
                assertThat().
                statusCode(httpResponse.getUserDoesntExist());
    }
}
