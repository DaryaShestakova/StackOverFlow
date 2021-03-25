package com.stackexchange.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stackexchange.api.BaseApi;
import com.stackexchange.entity.BaseRoot;
import com.stackexchange.tests.UsersStackExchangeTest.UsersFieldsTest;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;


public class BaseTest {

    private static final long MAX_TIMEOUT = 10000L;
    private static final int TIME_BETWEEN_REQUESTS = 120000;
    protected UsersFieldsTest usersFieldsTest = new UsersFieldsTest();
    protected Response response;
    protected SoftAssert softAssert = new SoftAssert();
    private static Logger logger = LogManager.getLogger();

    public <T extends BaseRoot> T getRoot (BaseApi baseApi, Class<T> clazz){
        String url = baseApi.buildEndPoint();

        logger.info(url);
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = resBuilder.build();

        tryingToGetSuccessResponse(url);
        String json = response.then().extract().body().asString();
        logger.info(json);

        Gson gson = new GsonBuilder().create();
        T root = gson.fromJson(json, clazz);
        return root;
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