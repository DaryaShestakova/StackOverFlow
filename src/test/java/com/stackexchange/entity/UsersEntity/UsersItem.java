package com.stackexchange.entity.UsersEntity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UsersItem {
    @SerializedName("badge_counts")
    public UsersBadgeCounts usersBadgeCounts;
    @SerializedName("account_id")
    public int accountId;
    @SerializedName("is_employee")
    public boolean isEmployee;
    @SerializedName("last_access_date")
    public int lastAccessDate;
    @SerializedName("reputation_change_year")
    public int reputationChangeYear;
    @SerializedName("reputation_change_quarter")
    public int reputationChangeQuarter;
    @SerializedName("reputation_change_month")
    public int reputationChangeMonth;
    @SerializedName("reputation_change_week")
    public int reputationChangeWeek;
    @SerializedName("reputation_change_day")
    public int reputationChangeDay;
    public int reputation;
    @SerializedName("creation_date")
    public long creationDate;
    @SerializedName("user_type")
    public String userType;
    @SerializedName("user_id")
    public int userId;
    public String link;
    @SerializedName("profile_image")
    public String profileImage;
    @SerializedName("display_name")
    public String displayName;
    public String location;
    @SerializedName("last_modified_date")
    public int lastModifiedDate;
    @SerializedName("website_url")
    public String websiteUrl;
}
