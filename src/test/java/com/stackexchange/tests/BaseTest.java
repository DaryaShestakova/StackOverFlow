package com.stackexchange.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stackexchange.entity.AnswersEntity.AnswersRoot;
import com.stackexchange.entity.BadgesEntity.BadgesRoot;
import com.stackexchange.entity.UsersEntity.UsersRoot;
import com.stackexchange.tests.AnswerStackExchangeTest.AnswersFieldsTest;
import com.stackexchange.tests.BadgesStackExchangeTest.BadgesFieldsTest;
import com.stackexchange.tests.UsersStackExchangeTest.UsersFieldsTest;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;

import static com.stackexchange.tests.StackExchangeTest.*;
import static io.restassured.RestAssured.given;


public class BaseTest {

    private static final long MAX_TIMEOUT = 10000L;
    private static final int TIME_BETWEEN_REQUESTS = 120000;
    protected AnswersFieldsTest answersFieldsTest = new AnswersFieldsTest();
    protected BadgesFieldsTest badgesFieldsTest = new BadgesFieldsTest();
    protected UsersFieldsTest usersFieldsTest = new UsersFieldsTest();
    protected Response response;
    protected AnswersRoot answersRoot;
    protected BadgesRoot badgesRoot;
    protected UsersRoot usersRoot;
    protected SoftAssert softAssert = new SoftAssert();
    private static Logger logger = LogManager.getLogger();

    @BeforeMethod
    public void setUp (Method method){
        String testName = method.getName();
        switch (testName) {
            case "testAnswersStackExchange":
                String answersUrl = answersApi.buildAnswersEndPoint();
                String answersJson = beforeSetUp(answersUrl);
                Gson answersGson = new GsonBuilder().create();
                answersRoot = answersGson.fromJson(answersJson, AnswersRoot.class);
                break;
            case "testBadgesStackExchange":
                String badgesUrl = badgesApi.buildBadgesEndPoint();
                String badgesJson = beforeSetUp(badgesUrl);
                Gson badgesGson = new GsonBuilder().create();
                badgesRoot = badgesGson.fromJson(badgesJson, BadgesRoot.class);
                break;
            case "testUsersStackExchange":
                String usersUrl = usersApi.buildUsersEndPoint();
                String usersJson = beforeSetUp(usersUrl);
                Gson usersGson = new GsonBuilder().create();
                usersRoot = usersGson.fromJson(usersJson, UsersRoot.class);
                break;
        }
    }

    public String beforeSetUp(String url){
        logger.info(url);
        responseBuilding();
        tryingToGetSuccessResponse(url);
        String answersJson = response.then().extract().body().asString();
        logger.info(answersJson);
        return answersJson;
    }

    public void responseBuilding(){
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = resBuilder.build();

    }

    @SneakyThrows(InterruptedException.class)
    public void tryingToGetSuccessResponse(String url) {
        int count = 0;
        while (count <= 5) {
            count++;
            response = given().when().get(url);
            if (response.getStatusCode() == 400) {
                Thread.sleep(TIME_BETWEEN_REQUESTS);
            } else {
                break;
            }
        }
    }
}