package com.stackexchange.entity.UsersEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UsersBadgeCounts {
    public int bronze;
    public int silver;
    public int gold;
}
