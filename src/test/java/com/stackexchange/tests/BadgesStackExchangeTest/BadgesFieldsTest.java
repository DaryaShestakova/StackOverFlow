package com.stackexchange.tests.BadgesStackExchangeTest;

import com.stackexchange.entity.BadgesEntity.BadgesRoot;
import com.stackexchange.entity.BadgesEntity.BadgesItem;
import com.stackexchange.tests.FieldsTest;

public class BadgesFieldsTest extends FieldsTest {
    public boolean checkBadgesFieldNotNull(BadgesRoot root, String fieldName){
        boolean flag = true;
        for (BadgesItem item : root.getBadgesItems()){
            if (!objectHasProperty(item, fieldName)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
