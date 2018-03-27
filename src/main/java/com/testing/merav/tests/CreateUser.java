package com.testing.merav.tests;
import com.testing.merav.infra.APICalls;
import com.testing.merav.infra.HttpResponse;
import com.testing.merav.infra.TestData;
import io.restassured.RestAssured;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.IsEqual.equalTo;

public class CreateUser {

    final private static Logger LOGGER = LoggerFactory.getLogger(CreateUser.class.getName());
    TestData testData = new TestData();
    HttpResponse httpResponse = new HttpResponse();


    @Test
    public void positiveScenario(){
        //TODO delete users in the end of the test to have the test robust

        LOGGER.info("Testing create user - response could should be valid:"+httpResponse.getUserAdded());

        //test input
        String username="tomer121";
        String password = "1234"; //not a good password, just for testing purposes

        RestAssured.baseURI=testData.getRestAPI();
        RestAssured.
                given().
                    param("username",username).
                    param("password",password).
                when().
                    get(APICalls.CREATE_USER.toString()).
                then().
                    assertThat().
                    statusCode(httpResponse.getUserAdded()).
                and().
                    body(containsString(username+" was added successfully"));
    }

    @Test
    public void negativeScenario(){
        LOGGER.info("Testing create user - response could should be not valid:"+httpResponse.getFail());
        //we should register user and register again, second time should fail

        //test input
        String username="merav21100"; //same user - result is different now
        String password = "123456";

        String expectedResultMessage="Could not add user "+username+" username already exist";
        RestAssured.baseURI=testData.getRestAPI();
        RestAssured.
                given().
                param("username",username).
                param("password",password).
                when().
                get(APICalls.CREATE_USER.toString()).
                then().
                assertThat().
                statusCode(httpResponse.getFail()).
                and().
                body("message", equalTo(expectedResultMessage));

    }
}
