package com.stackexchange.entity.UsersEntity;

import com.google.gson.annotations.SerializedName;
import com.stackexchange.entity.BaseRoot;
import lombok.Getter;

import java.util.List;

@Getter
public class UsersRoot extends BaseRoot {
    @SerializedName("items")
    public List<UsersItem> usersItems;

    public UsersRoot(boolean hasMore, int quotaMax, int quotaRemaining, List<UsersItem> usersItems) {
        super(hasMore, quotaMax, quotaRemaining);
        this.usersItems = usersItems;
    }
}
