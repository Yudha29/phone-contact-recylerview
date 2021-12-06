package com.yudha29.contactperson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderService {
    @GET("users")
    Call<List<User>> getUsers();
}
