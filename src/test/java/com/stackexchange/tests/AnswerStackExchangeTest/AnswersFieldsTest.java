package com.stackexchange.tests.AnswerStackExchangeTest;

import com.stackexchange.entity.AnswersEntity.AnswersRoot;
import com.stackexchange.entity.AnswersEntity.AnswersItem;
import com.stackexchange.entity.AnswersEntity.AnswersOwner;
import com.stackexchange.tests.FieldsTest;

import java.util.List;

public class AnswersFieldsTest extends FieldsTest {
    public boolean checkAnswersFieldNotNull(AnswersRoot root, String fieldName){
        List<AnswersItem> items = root.getAnswersItems();
        boolean flag = true;
        for (AnswersItem item : items){
            AnswersOwner owner = item.getAnswersOwner();
            if (!objectHasProperty(owner, fieldName)){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
