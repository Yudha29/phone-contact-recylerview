package com.yudha29.contactperson;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Service to fetch user data from json placeholder API
 *
 */

public interface JSONPlaceHolderService {
    // Get all users
    @GET("users")
    Call<List<User>> getUsers();
}
