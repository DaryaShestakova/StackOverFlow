package com.stackexchange.entity.BadgesEntity;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BadgesRoot {

    @SerializedName("items")
    public List<BadgesItem> badgesItems;
    @SerializedName("has_more")
    public boolean hasMore;
    @SerializedName("quota_max")
    public int quotaMax;
    @SerializedName("quota_remaining")
    public int quotaRemaining;
}
