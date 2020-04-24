package com.example.taks.reposetories;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsRepo {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private Retrofit retrofit;

    private PostsRepo() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        this.retrofit = retrofit;

    }
    public static synchronized PostsRepo getInstance(){
        return new PostsRepo();
    }

    public Retrofit createRetrofitConnection() {
        return this.retrofit;
    }
}
