package com.stackexchange.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.stackexchange.api.UsersApi.RESOURCE;

@Getter
@AllArgsConstructor
public abstract class BaseApi {

    public final String BASE_API = "https://api.stackexchange.com/2.2";
    public final String site = "stackoverflow";
    protected int page;
    protected int pageSize;
    protected String order;
    protected String sort;
    protected String filter;

    public String buildEndPoint(String resource){
        return this.BASE_API + "/" + resource + "?" +
                "site=" + this.site +
                "&page=" + this.page +
                "&pageSize=" + this.pageSize +
                "&order=" + this.order +
                "&sort=" + this.sort +
                "&filter=" + this.filter;
    }
}
