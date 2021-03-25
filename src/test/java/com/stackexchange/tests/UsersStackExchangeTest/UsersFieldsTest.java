package com.stackexchange.tests.UsersStackExchangeTest;

import com.stackexchange.entity.UsersEntity.UsersItem;
import com.stackexchange.entity.UsersEntity.UsersRoot;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class UsersFieldsTest{

    public boolean checkUsersFieldDisplayNameContainsString(UsersRoot root, String someString){
        boolean flag = true;
        for (UsersItem item : root.getUsersItems()){
            if (!((item.getDisplayName()).toLowerCase(Locale.ROOT).contains(someString))){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean checkUsersFieldReputationSortedFromLessToMore(UsersRoot root){
        boolean flag = true;
        List<UsersItem> usersItems = root.getUsersItems();
        for (int i = 0; i < usersItems.size()-1;){
            int firstReputation = usersItems.get(i).getReputation();
            int secondReputation = usersItems.get(++i).getReputation();
            if (!(firstReputation <= secondReputation)){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean checkUsersFieldCreationDateBelongsToPeriodFromFilter(UsersRoot root, long fromDateLong, long toDateLong){
        boolean flag = true;
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        Date fromDate = new Date(fromDateLong*1000);
        Date toDate = new Date(toDateLong*1000);
        for (UsersItem item : root.getUsersItems()){
            Date creationDate = new Date(item.getCreationDate()*1000);
            if (!(creationDate.after(fromDate) && creationDate.before(toDate))){
                flag = false;
                break;
            }
        }
        return flag;
    }
}
