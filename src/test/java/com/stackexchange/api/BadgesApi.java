package com.stackexchange.api;

import lombok.Getter;

@Getter
public class BadgesApi extends BaseApi{
    private static final String RESOURCE = "badges";

    public BadgesApi(int page, int pageSize, String order, String sort, String filter) {
        super(page, pageSize, order, sort, filter);
    }

    public String buildBadgesEndPoint(){
        return buildEndPoint(RESOURCE);
    }
}
