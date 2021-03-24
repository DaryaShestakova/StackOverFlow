package com.stackexchange.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class BaseApi {

    public final String BASE_API = "https://api.stackexchange.com/2.2";
    public final String site = "stackoverflow";
    private int page;
    private int pageSize;
    private String order;
    private String sort;
    private String filter;

    public abstract String buildEndPoint();

    public String buildBaseEndPoint(String resource){
        return BASE_API + "/" + resource + "?" +
                "site=" + site +
                "&page=" + page +
                "&pageSize=" + pageSize +
                "&order=" + order +
                "&sort=" + sort +
                "&filter=" + filter;
    }
}
