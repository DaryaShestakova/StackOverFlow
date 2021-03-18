package com.stackexchange.tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stackexchange.api.AnswersApi;
import com.stackexchange.entity.Item;
import com.stackexchange.entity.Owner;
import com.stackexchange.entity.Root;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class BaseTest {

    public static final long MAX_TIMEOUT = 10000L;
    public static final int TIME_BETWEEN_REQUESTS = 120000;
    protected AnswersApi.AnswersApiBuilder answersApiBuilder;
    protected Root root;
    protected Response response;
    protected String url;

    @BeforeClass
    public void setUp() throws Exception {
        answersApiBuilder = AnswersApi
                .builder()
                .filter("default")
                .sort("activity")
                .order("desc")
                .pageSize(10)
                .page(1)
                .site("stackoverflow");
        url = answersApiBuilder.build().buildEndpoint();
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = resBuilder.build();

        tryingToGetSuccessResponse(url);
        String jsonString = response.then().extract().body().asString();
        Gson gson = new GsonBuilder().create();
        root = gson.fromJson(jsonString, Root.class);
    }

    private void tryingToGetSuccessResponse(String url)throws InterruptedException{
        int count = 0;
        while (count <= 5){
            count++;
            response = given().when().get(url);
            if (response.getStatusCode() == 200){
                break;
            }else {
                Thread.sleep(TIME_BETWEEN_REQUESTS);
            }
        }
    }

    public boolean checkOwnersFields (String fieldName){
        List<Item> items = root.getItems();
        boolean flag = true;
        for (Item item : items){
            Owner owner = item.getOwner();
            if (!objectHasProperty(owner, fieldName)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    private Boolean objectHasProperty(Object obj, String fieldName){
        List<Field> fields = getAllFields(obj);
        for(Field field : fields){
            if(field.getName().endsWith(fieldName)){
                return true;
            }
        }
        return false;
    }

    private List<Field> getAllFields(Object obj){
        List<Field> fields = new ArrayList();
        for (Field field: obj.getClass().getDeclaredFields()) {
            fields.add(field);
        }
        return fields;
    }
}
