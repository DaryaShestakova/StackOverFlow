package com.stackexchange.entity.BadgesEntity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BadgesItem {
    @SerializedName("badge_typ")
    public String badgeType;
    @SerializedName("award_count")
    public int awardCount;
    public String rank;
    @SerializedName("badge_id")
    public int badgeId;
    public String link;
    public String name;
}
