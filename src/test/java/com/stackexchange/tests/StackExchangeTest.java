package com.stackexchange.tests;

import com.stackexchange.api.AnswersApi;
import com.stackexchange.api.BadgesApi;
import com.stackexchange.api.UsersApi;
import com.stackexchange.entity.AnswersEntity.AnswersItem;
import com.stackexchange.entity.AnswersEntity.AnswersOwner;
import com.stackexchange.entity.AnswersEntity.AnswersRoot;
import com.stackexchange.entity.BadgesEntity.BadgesItem;
import com.stackexchange.entity.BadgesEntity.BadgesRoot;
import com.stackexchange.entity.UsersEntity.UsersItem;
import com.stackexchange.entity.UsersEntity.UsersRoot;
import org.testng.annotations.Test;

import java.util.List;

public class StackExchangeTest extends BaseTest{

    private AnswersApi answersApi = new AnswersApi(1,10,"desc", "activity", "default");
    private BadgesApi badgesApi = new BadgesApi(1, 10, "desc", "rank", "default");
    private UsersApi usersApi = new UsersApi(1, 10, "asc", "reputation", "default", "kevin", 1614556800, 1616198400);

    @Test
    public void testAnswersStackExchange(){
        AnswersRoot answersRoot = getRoot(answersApi, AnswersRoot.class);
        softAssert.assertEquals(200, response.statusCode());
        softAssert.assertTrue(answersRoot.getItemsSize() <= 10);

        List<AnswersItem> items = answersRoot.getAnswersItems();
        for (AnswersItem item : items){
            AnswersOwner owner = item.getAnswersOwner();
            softAssert.assertNotEquals(owner.getDisplayName(), null);
            softAssert.assertNotEquals(owner.getUserId(), null);
        }

        softAssert.assertAll();
    }

    /**
     * 1.Title. Test statusCode of response.
     *   Steps. CreateURL from BadgesApiBuilder.Send request to server.Get status code of response.Check if status code equals 200.
     *   Expected result. Status code of Badges endpoint response is 200.
     *
     * 2.Title. Check value of verifiable field not null.
     *   Steps. CreateURL from BadgesApiBuilder.Send request to server.Get response. Parse response to entity objects.
     *                          Pass to test method field name as string.Check reported fields of BadgesItem not null.
     *   Expected result. Value of verifiable field not null.
     */

    @Test
    public void testBadgesStackExchange(){
        BadgesRoot badgesRoot = getRoot(badgesApi, BadgesRoot.class);
        softAssert.assertEquals(200, response.statusCode());//1

        for (BadgesItem item : badgesRoot.getBadgesItems()){
            softAssert.assertNotEquals(item.getAwardCount(), null);
            softAssert.assertNotEquals(item.getRank(), null);
        }

        softAssert.assertAll();
    }

    /**
     * 1.Title. Test statusCode of response.
     *   Steps. CreateURL from UsersApiBuilder. Send request to server. Get status code of response. Check if status code equals 200.
     *   Expected result. Status code of Users endpoint response is 200.
     *
     * 2.Title. Check value of verifiable field not null.
     *   Steps. CreateURL from UsersApiBuilder. Send request to server. Get response. Parse response to entity objects.
     *                             Pass to test method field name. Check reported field of UsersItem not null.
     *   Expected result. Value of verifiable field not null
     *
     * 3.Title. Check field display_name contains string.
     *   Steps. CreateURL from UsersApiBuilder. Send request to server. Get response. Parse response to entity objects.
     *                             Pass to test method some string. Check field display_name contains reported string.
     *   Expected result. Field display_name contains reported string.
     *
     * 4. Title. Check value of field creation_date belongs to interval between two dates from endpoint filter.
     *    Steps. CreateURL from UsersApiBuilder. Send request to server. Get response. Parse response to entity objects.
     *                             Test method receive start date and end date from endpoint filter. Check creation_date belongs to interval between two dates.
     *    Expected result. Value of field creation_date belongs to interval between two dates from endpoint filter.
     *
     * 5. Title. Check items sorted in ascending order by field reputation.
     *    Steps. CreateURL from UsersApiBuilder. Send request to server. Get response. Parse response to entity objects.
     *                              Check each next item has value of field reputation more than has previous one.
     *    Expected result. Items sorted in ascending order by field reputation.
     */

    @Test
    public void testUsersStackExchange(){
        UsersRoot usersRoot = getRoot(usersApi, UsersRoot.class);
        softAssert.assertEquals(200, response.statusCode());//1

        for (UsersItem item : usersRoot.getUsersItems()){
            softAssert.assertNotEquals(item.getReputation(), null);
        }

        softAssert.assertTrue(usersFieldsTest.checkUsersFieldDisplayNameContainsString(usersRoot, "kevin"));//3
        softAssert.assertTrue(usersFieldsTest.checkUsersFieldCreationDateBelongsToPeriodFromFilter(usersRoot, usersApi.getFromDate(), usersApi.getToDate()));//4
        softAssert.assertTrue(usersFieldsTest.checkUsersFieldReputationSortedFromLessToMore(usersRoot));//5
        softAssert.assertAll();
    }
}

