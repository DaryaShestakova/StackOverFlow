package com.stackexchange.api;

import lombok.Getter;

@Getter
public class UsersApi extends BaseApi{

    private static final String RESOURCE = "users";
    private String inName;
    private long fromDate;
    private long toDate;

    public UsersApi(int page, int pageSize, String order, String sort, String filter, String inName, long fromDate, long toDate) {
        super(page, pageSize, order, sort, filter);
        this.inName = inName;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    @Override
    public String buildEndPoint(){
        return buildBaseEndPoint(RESOURCE) +
                "&inname=" + inName +
                "&fromdate=" + fromDate +
                "&todate=" + toDate;
    }
}
