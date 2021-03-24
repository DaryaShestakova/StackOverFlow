package com.stackexchange.entity.AnswersEntity;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.stackexchange.entity.BaseRoot;
import lombok.Getter;

@Getter
public class AnswersRoot extends BaseRoot {
    @SerializedName("items")
    public List<AnswersItem> answersItems;
    @SerializedName("backoff")
    public int itemsSize;

    public AnswersRoot(boolean hasMore, int quotaMax, int quotaRemaining, List<AnswersItem> answersItems, int itemsSize) {
        super(hasMore, quotaMax, quotaRemaining);
        this.answersItems = answersItems;
        this.itemsSize = itemsSize;
    }
}
