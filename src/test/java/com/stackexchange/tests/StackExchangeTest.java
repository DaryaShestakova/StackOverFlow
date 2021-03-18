package com.stackexchange.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class StackExchangeTest extends BaseTest{

    @Test
    public void testStackExchange(){
        SoftAssert sa= new SoftAssert();
        sa.assertEquals(200, response.statusCode());
        sa.assertTrue(root.getBackoff() < 11);
        sa.assertTrue(checkOwnersFields("display_name"));
        sa.assertTrue(checkOwnersFields("user_id"));
        sa.assertAll();
    }
}

