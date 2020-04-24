package com.example.taks.reposetories;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginRepo {
    private static final String BASE_URL = "http://139.59.87.150/demo/Shree_Sai_Mall/public/api/";
    private Retrofit retrofit;

    private LoginRepo() {
        OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized LoginRepo getInstant() {
        return new LoginRepo();
    }

    public Retrofit getClient() {
        return this.retrofit;
    }

}
