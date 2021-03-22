package com.stackexchange.entity.AnswersEntity;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AnswersRoot {
    @SerializedName("items")
    public List<AnswersItem> answersItems;
    @SerializedName("has_more")
    public boolean hasMore;
    @SerializedName("backoff")
    public int itemsSize;
    @SerializedName("quota_max")
    public int quotaMax;
    @SerializedName("quota_remaining")
    public int quotaRemaining;
}
