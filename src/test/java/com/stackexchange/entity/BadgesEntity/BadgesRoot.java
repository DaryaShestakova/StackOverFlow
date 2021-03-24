package com.stackexchange.entity.BadgesEntity;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.stackexchange.entity.BaseRoot;
import lombok.Getter;


@Getter
public class BadgesRoot extends BaseRoot {

    @SerializedName("items")
    public List<BadgesItem> badgesItems;

    public BadgesRoot(boolean hasMore, int quotaMax, int quotaRemaining, List<BadgesItem> badgesItems) {
        super(hasMore, quotaMax, quotaRemaining);
        this.badgesItems = badgesItems;
    }
}
