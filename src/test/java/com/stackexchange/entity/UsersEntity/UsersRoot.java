package com.stackexchange.entity.UsersEntity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class UsersRoot {
    @SerializedName("items")
    public List<UsersItem> usersItems;
    @SerializedName("has_more")
    public boolean hasMore;
    @SerializedName("quota_max")
    public int quotaMax;
    @SerializedName("quota_remaining")
    public int quotaRemaining;
}
