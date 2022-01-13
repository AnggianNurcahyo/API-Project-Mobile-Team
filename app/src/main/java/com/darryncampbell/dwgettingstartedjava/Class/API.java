package com.darryncampbell.dwgettingstartedjava.Class;

public class API {
    public static final String API_URL = "http://192.168.100.65:8080/";

    private API() {

    }

    public static UserService getUserService(){
        return RetrofitClient.getClient(API_URL).create(UserService.class);
    }


}
