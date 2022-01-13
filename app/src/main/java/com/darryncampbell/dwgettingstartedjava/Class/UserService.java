package com.darryncampbell.dwgettingstartedjava.Class;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {
    @GET("login")
    Call<User> getLogin(@Query("npk") String npk, @Query("password") String password);

    @GET("users")
    Call<List<User>> getUsers();
}
