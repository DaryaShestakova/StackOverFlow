package com.stackexchange.api;

import lombok.Getter;

@Getter
public class AnswersApi extends BaseApi {

    private static final String RESOURCE = "answers";

    public AnswersApi(int page, int pageSize, String order, String sort, String filter) {
        super(page, pageSize, order, sort, filter);
    }

    @Override
    public String buildEndPoint() {
        return buildBaseEndPoint(RESOURCE);
    }
}
