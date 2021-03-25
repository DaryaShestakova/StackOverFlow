package com.stackexchange.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class BaseRoot {
    @SerializedName("has_more")
    public boolean hasMore;
    @SerializedName("quota_max")
    public int quotaMax;
    @SerializedName("quota_remaining")
    public int quotaRemaining;
}
