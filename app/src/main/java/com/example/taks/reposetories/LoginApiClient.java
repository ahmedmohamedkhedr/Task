package com.example.taks.reposetories;

import com.example.taks.models.AccountModel;
import com.example.taks.models.ApiResponse;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApiClient {
    @POST("user-login")
    Call<ApiResponse> login(@Body AccountModel data);
}
