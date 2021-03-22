package com.stackexchange.entity.AnswersEntity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AnswersItem {
    @SerializedName("owner")
    public AnswersOwner answersOwner;
    @SerializedName("is_accepted")
    public boolean isAccepted;
    public int score;
    @SerializedName("last_activity_date")
    public int lastActivityDate;
    @SerializedName("creation_date")
    public int creationDate;
    @SerializedName("answer_id")
    public int answerId;
    @SerializedName("question_id")
    public int questionId;
    @SerializedName("content_license")
    public String contentLicense;
    @SerializedName("last_edit_date")
    public int lastEditDate;
}
