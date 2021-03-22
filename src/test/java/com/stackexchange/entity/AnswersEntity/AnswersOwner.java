package com.stackexchange.entity.AnswersEntity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder

public class AnswersOwner {
    public int reputation;
    @SerializedName("user_id")
    public int userId;
    @SerializedName("user_type")
    public String userType;
    @SerializedName("profile_image")
    public String profileImage;
    @SerializedName("display_name")
    public String displayName;
    public String link;
    @SerializedName("accept_rate")
    public int acceptRate;
}
