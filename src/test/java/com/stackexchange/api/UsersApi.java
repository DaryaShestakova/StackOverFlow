package com.stackexchange.api;

import lombok.Getter;

@Getter
public class UsersApi extends BaseApi{

    protected static final String RESOURCE = "users";
    private String inName;
    private long fromDate;
    private long toDate;

    public UsersApi(int page, int pageSize, String order, String sort, String filter, String inName, long fromDate, long toDate) {
        super(page, pageSize, order, sort, filter);
        this.inName = inName;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String buildUsersEndPoint(){
        return buildEndPoint(RESOURCE) +
                "&inname=" + this.inName +
                "&fromdate=" + this.fromDate +
                "&todate=" + this.toDate;
    }
}
